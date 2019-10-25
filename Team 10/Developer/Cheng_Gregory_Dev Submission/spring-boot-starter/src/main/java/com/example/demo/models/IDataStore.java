package com.example.demo.models;

import java.time.LocalDateTime;

public interface IDataStore {

	PredictedStats getPrediction(String title, String profile, String[] tags, LocalDateTime publishDate);

}
