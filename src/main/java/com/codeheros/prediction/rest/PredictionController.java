package com.codeheros.prediction.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PredictionController {

    @PostMapping("getPrediction")
    public String getPrediction(){
        return "";
    }
}
