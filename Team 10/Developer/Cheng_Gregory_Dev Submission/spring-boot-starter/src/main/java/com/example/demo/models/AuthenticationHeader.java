package com.example.demo.models;


import com.example.demo.sessions.SessionTable;

import java.util.UUID;

/**
 * The AuthenticationHeader class models a session token that is sent to the user upon login.
 */
public class AuthenticationHeader {

	public AuthenticationHeader(String username, String sessionId) {
		this.username = username;
		this.sessionId = UUID.fromString(sessionId);
	}

	/**
	 * Authenticates the user. This involves retrieving the user ID and session ID from the header of the request and
	 * checking with the hash table if it constitutes a valid login.
	 * @return If the session is valid
	 */
	public static boolean authenticate(String username, String sessionId) {
		AuthenticationHeader header = new AuthenticationHeader(username, sessionId);
		return SessionTable.getInstance().verifySession(header.sessionId, header.username);
	}

	private String username;

	private UUID sessionId;

	public String getUsername() {
		return username;
	}

	public UUID getSessionId(){
		return sessionId;
	}

}