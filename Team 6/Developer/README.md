# Unicorn Views Predictor  

#### Description

A website which accepts the title of the video and the classification category and it will return an approximation of the number of views.
This will determine an approximations on the number of views.

Predictions are made based on statistics about past videos other Youtubers have uploaded, and predicted results are only estimations.


#### Model - View - Controller Architecture

Model - Handles the from the Sequential Neural Network which analyzes the prediction
Controller - Passes information from the view to the model
View - Controls all code which gets text from user input

#### Dependencies

Python=3.8
Keras=2.3.0
nltk=3.4.5
