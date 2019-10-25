# Architecture Outline

## MVC: Model View Controller
### Description: 
* Separates presentation and interaction from system data.
* Three logical components that interact with each other
* View defines and manages how we display data to the user
* Controller manages user interaction with the system.

### Advantages:
* Allows us to change the underlying model independently of the rest of the system.
* Can support multiple Views for different ways of displaying to user. Can have different views for larger/smaller users
* Changes made in one component will show in the overall system.

### Disadvantages:
* Adds additional code complexity.

## In-depth Description
The View object sits on the client side to take user input and display responses from the server. When the user needs to get a prediction,
the View object sends a request to the Controller.

The request is intercepted by a web server which parses the request
then tries to generate a prediction to send back the client. The model performs the analysis of user inputs to generate the prediction to send back to the client.
Ideally, the web server would be concurrent to allow for handling of multiple client connections at once, so that is an area for extension.

The separation of each component allows us to extend the View object to allow for additional customization. For example,
different Views can be offered to different tier clients (Ex. different sized Youtubers).
Likewise, the separation of the Model from the Controller, allows us to create different models depending on the context.
For example, we may need a different model for the Youtubers in the US compared to Youtubers in Germany.
The subclassing of Input allows for the customization of inputs for their corresponding model.