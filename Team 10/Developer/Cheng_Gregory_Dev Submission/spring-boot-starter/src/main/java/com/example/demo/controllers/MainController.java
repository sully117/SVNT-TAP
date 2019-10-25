package com.example.demo.controllers;

import com.example.demo.DataStore;
import com.example.demo.constants.RequestConstants;
import com.example.demo.models.AuthenticationHeader;
import com.example.demo.models.PredictedStats;
import com.example.demo.sessions.SessionTable;
import com.example.demo.util.DateTimeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class MainController {

	@RequestMapping(value = "/get-prediction", method = RequestMethod.GET)
	public PredictedStats getPrediction(
			@RequestParam(name = RequestConstants.TITLE, required = false) String title,
			@RequestParam(name = RequestConstants.TAGS, required = false) String[] tags,
			@RequestParam(name = RequestConstants.PUBLISH_DATE, required = false) String publishDateString,
			@RequestParam(name = RequestConstants.AUTHENTICATION_HEADER) AuthenticationHeader header
	) {

		if (!SessionTable.getInstance().verifySession(header)) {
			return null;
		}

		DataStore store = DataStore.getInstance();
		LocalDateTime publishDate = LocalDateTime.now();
		if (publishDateString != null) {
			publishDate = DateTimeUtil.stringToLocalTime(publishDateString);
		}

		return store.getPrediction(title, header.getUsername(), tags, publishDate);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public AuthenticationHeader register(
			@RequestParam(name = RequestConstants.USERNAME) String username,
			@RequestParam(name = RequestConstants.PASSWORD) String passwordHash
	) {

		if (DataStore.getInstance().usernameExists(username)) {
			return null;
		}

		System.out.println("account created");

		DataStore.getInstance().addNewUser(username, passwordHash);
		return SessionTable.getInstance().createNewSession(username);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthenticationHeader login(
			@RequestParam(name = RequestConstants.USERNAME) String username,
			@RequestParam(name = RequestConstants.PASSWORD) String passwordHash
			) {
		if (DataStore.getInstance().passwordMatch(username, passwordHash)) {
			return SessionTable.getInstance().createNewSession(username);
		}
		return null;
	}

	@RequestMapping(value = "/current-date", method = RequestMethod.GET)
	public Date time() {
		return new Date();
	}

}
