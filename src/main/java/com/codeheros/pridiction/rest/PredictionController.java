package com.codeheros.pridiction.rest;

import com.codeheros.pridiction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("getPrediction")
    public ResponseEntity<String> getPrediction(){
        String prediction = predictionService.getPrediction();
        return ResponseEntity.ok(prediction);
    }
}
