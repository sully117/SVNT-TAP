const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const cors = require('cors');
const mongoose = require('mongoose');
const logRoutes = express.Router();
const PORT = 4000;

app.use(cors());
app.use(bodyParser.json());
//load schema
let LOGS = require('./log.module');

mongoose.connect('mongodb://127.0.0.1:27017/Tune', { useNewUrlParser: true });
const connection = mongoose.connection;
//enables furhter query
const query = LOGS.find();

logRoutes.route('/').get(function(req, res) {
    LOGS.find(function(err, logs) {
        if (err) {
            console.log(err);
        } else {
            res.json(logs);
            console.log(logs);
        }
    });
});

//Http get with param userName to read single userName instance
logRoutes.route('/:userName').get(function(req, res) {
    let userName = req.params.id;
    LOGS.find({userName:userName}, function(err, results){
      if (err){
        console.log(err);
      }
      else{
        res.json(result);
        console.log(logs);
      }
    });
});
