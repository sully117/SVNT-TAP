package com.example.demo;

import com.example.demo.models.IDataStore;
import com.example.demo.models.PredictedStats;
import com.example.demo.models.YoutuberProfile;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Generic data store. To keep it general, we'll have a HashMap of objects and an ArrayList of objects.
 */
public class DataStore implements IDataStore {

	/**
	 * Used for singleton design pattern
	 */
	private static DataStore dataStore;

	private static HashMap<String, String> authTable;
	private static HashMap<String, YoutuberProfile> profiles;

	private DataStore() {
		authTable = new HashMap<>();
		profiles = new HashMap<>();
	}

	public static DataStore getInstance() {

		if (authTable == null && profiles == null) {
			dataStore = new DataStore();
		}

		return dataStore;

	}

	/**
	 * STUB METHOD
	 */
	public PredictedStats getPrediction(String title, String username, String[] tags, LocalDateTime publishDate) {

		// Get YouTube profile to for predictive information
		YoutuberProfile profile = profiles.get(username);

		double[] probabilities = new double[]{.1, .2, .3};

		return new PredictedStats(
			probabilities,
			1, 1, 1
		);

	}

	public boolean passwordMatch(String username, String password) {
		return authTable.get(username).equals(password);
	}

	public boolean usernameExists(String username) {
		return authTable.containsKey(username);
	}

	public void addNewUser(String username, String password) {
		authTable.put(username, password);
	}

	public HashMap<String, String> getAuthTable() {
		return authTable;
	}

	public HashMap<String, YoutuberProfile> getProfiles() {
		return profiles;
	}

}
