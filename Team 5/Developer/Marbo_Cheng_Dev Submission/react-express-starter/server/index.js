// Import the express framework for our node server
const express = require('express');
// Import the path module from node to create absolute file paths for express static
const path = require('path');

// Instantiate the express server
const app = express();
// Set a constant for the port that our express server will listen on
const PORT = 3000;

const bodyParser = require('body-parser');

const youtubeVideos = require('../db-postgres/controller.js');
app.use(bodyParser.urlencoded({ extended: true })); 
app.use(bodyParser.json());
// Serve static files. Any requests for specific files will be served if they exist in the provided folder
app.use(express.static(path.join(__dirname, '../client/dist')));
// Start the server on the provided port


app.get('/api/tags', async (req, res) => {
    /*
    Input: tags, timePeriod= week
    Output: 
    */
    try {
      let term = req.body.term;
      console.log('api/tags', req.body);
      const getTags = await youtubeVideos.getAllTags();
      res.status(200).send(getTags);
    } catch (e) {
      res.status(400).send(e);
    }
  });


app.get('/api/searchTags', async (req, res) => {
    /*
    Input: tags, timePeriod= week
    Output: 
    */
    try {
      let term = req.body.term;
      console.log('api/searchtag', req.body);
      const getTopTags = await youtubeVideos.searchTag(term);
      res.status(200).send(getTopTags);
    } catch (e) {
      res.status(400).send(e);
    }
  });

  
  

  app.listen(PORT, () => console.log('Listening on port: ' + PORT));
