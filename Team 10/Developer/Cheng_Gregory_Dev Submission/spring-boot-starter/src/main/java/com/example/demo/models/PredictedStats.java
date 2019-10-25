package com.example.demo.models;

public class PredictedStats {

	public int views;
	public int likes;
	public int dislikes;
	public double[] trendingProbability;

	public PredictedStats (double[] trendingProbability, int views, int likes, int dislikes) {
		this.trendingProbability = trendingProbability;
		this.views = views;
		this.likes = likes;
		this.dislikes = dislikes;
	}

}
