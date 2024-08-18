package com.codeheros.prediction.service;

import com.codeheros.prediction.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    @Autowired
    private ModelUtil modelUtil;

    public String getPrediction(){
        return modelUtil.irisPredict(4,4,4,4);
    }

}