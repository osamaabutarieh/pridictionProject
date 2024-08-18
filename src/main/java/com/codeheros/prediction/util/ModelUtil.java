package com.codeheros.prediction.util;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;

import java.util.HashMap;
import java.util.Map;

public class ModelUtil
{
    private static final String IRIS_PKL_MODEL_PATH = "src/main/java/com/codeheros/prediction/models/iris_knn_model.pkl";
    private static final String IRIS_ONNX_MODEL_PATH = "src/main/java/com/codeheros/prediction/models/iris_knn_model.onnx";
    private static OrtEnvironment env;
    private static OrtSession session;
    
    private ModelUtil()
    {
    
    }
    
    static
    {
        try
        {
            // Initialize ONNX Runtime
            env = OrtEnvironment.getEnvironment();
            session = env.createSession( IRIS_ONNX_MODEL_PATH );
        }
        catch(OrtException e)
        {
            e.printStackTrace();
            throw new RuntimeException( "Failed to initialize ONNX Runtime session" , e );
        }
    }

    
    /*
        using Iris Dataset
    
        There are 150 iris plants,
        each with 4 numeric attributes:
        sepal length in cm,
        sepal width in cm,
        petal length in cm,
        and petal width in cm.
        
        The task is to predict each plant as
        an iris-setosa,
        an iris-versicolor,
        or an iris-virginica based on these attributes.
	 */
    
    public static String irisPredict(float sepalLength , float sepalWidth , float petalLength , float petalWidth)
    {
        try
        {
            // Prepare input tensor
            float[] inputArray = { sepalLength , sepalWidth , petalLength , petalWidth };
            OnnxTensor inputTensor = OnnxTensor.createTensor( env , new float[][]{ inputArray } );
            
            // Run inference
            Map<String, OnnxTensor> inputs = new HashMap<>();
            inputs.put( "float_input" , inputTensor );
            OrtSession.Result result = session.run( inputs );
            
            // Process output
            float[] outputArray = (float[]) result.get( 0 ).getValue();
            // Assuming output is class probabilities or logits, find the index of the max value
            int predictedIndex = argmax( outputArray );
            return mapIndexToClass( predictedIndex );
        }
        catch(OrtException e)
        {
            e.printStackTrace();
            throw new RuntimeException( "Failed to run inference" , e );
        }
    }
    
    private static int argmax(float[] array)
    {
        int maxIndex = 0;
        for(int i = 1 ; i < array.length ; i++)
        {
            if(array[i] > array[maxIndex])
            {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private static String mapIndexToClass(int index)
    {
        switch(index)
        {
            case 0:
                return "iris-setosa";
            case 1:
                return "iris-versicolor";
            case 2:
                return "iris-virginica";
            default:
                throw new IllegalArgumentException( "Invalid class index" );
        }
    }
}
