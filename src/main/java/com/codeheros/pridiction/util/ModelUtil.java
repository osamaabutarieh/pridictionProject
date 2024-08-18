package com.codeheros.pridiction.util;

public class ModelUtil {
    private ModelUtil() {
    
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
    
    public static String irisPredict(int sepalLength, int sepalWidth, int petalLength, int petalWidth) {
        int x = sepalLength+sepalWidth+petalLength+petalWidth;
        return "iris-setosa";// or iris-versicolor or iris-virginica
    }
}
