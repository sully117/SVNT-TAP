# Youtube Prediction Application: SAP SVNT 2019

This application utilizes an authentication service in order to allow users to pull their profile information from a server and view the probability of their hypothetical videos trending. This allows users to get a greater insight of their audiences and how future videos of theirs will perform.

The user will register with a hash of their password. This is stored in an in-memory database, and the server sends back a session ID. Depending on the session ID, users are able to check statistics of their future videos by submitting hypothetical tags, title, and other parameters.
