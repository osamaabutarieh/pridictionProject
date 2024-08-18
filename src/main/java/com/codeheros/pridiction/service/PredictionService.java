package com.codeheros.pridiction.service;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    public String getPrediction(){
        return "iris-setosa";
    }

}
