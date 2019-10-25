package com.example.demo.sessions;

import com.example.demo.models.AuthenticationHeader;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionTable {

	private static SessionTable hashTable = new SessionTable();

	private SessionTable() {}

	public static SessionTable getInstance() {
		return hashTable;
	}

	/**
	 * Hash map that maps the String login tokens to usernames.
	 * This is stored in a ConcurrentHashMap in order to account for concurrency.
	 */
	private Map<UUID, String> map = new ConcurrentHashMap<>(1000);


	/**
	 * Creates a new session by checking if the user is already logged in.
	 * If they are already logged in, they must be logged out.
	 * This means that their entry must be revoked from the HashMap and a new session token must be created.
	 * We accomplish this by searching the entire map for the userID, and then removing the key/value pair if it exists.
	 * @param username username
	 * @return new UUID key to the hashmap
	 */
	public AuthenticationHeader createNewSession(String username) {
		endSessionByUsername(username);
		UUID uuid = UUID.randomUUID();
		map.put(uuid, username);
		return new AuthenticationHeader(username, uuid.toString());
	}

	public boolean verifySession(AuthenticationHeader header) {
		return verifySession(header.getSessionId(), header.getUsername());
	}

	/**
	 * Verifies a session in the hash map by matching the hash of the provided UUID to the user ID.
	 * If they match, then a valid login is confirmed.
	 * @param uuid UUID key in the map
	 * @param username Username
	 * @return Whether the session is valid or not
	 */
	public boolean verifySession(UUID uuid, String username) {
		return username.equals(map.get(uuid));
	}

	/**
	 * When given the UUID, this method removes it from the map.
	 * @param uuid UUID to remove
	 */
	public void endSessionByUUID(UUID uuid) {
		map.remove(uuid);
	}

	/**
	 * Ends a session by user id. This iterates through the set in order to remove from a hash map by value.
	 * @param username user that is logging out or abandoning a session.
	 */
	private void endSessionByUsername(String username) {
		for (UUID i : map.keySet()) {
			if (map.get(i).equals(username)){
				map.remove(i);
			}
		}
	}

}