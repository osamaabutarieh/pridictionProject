package com.codeheros.pridiction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PredictionApplication {
	
	/*
	Iris Dataset

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

	public static void main(String[] args) {//hello from the other side
		SpringApplication.run(PredictionApplication.class, args);
	}

}
