//React App- App service starting point
import React, { Component } from 'react';
import ReactGA from 'react-ga';
//import $ from 'jquery';
class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      working: 'yes',
    };

    ReactGA.initialize('UA-110570651-1');
    ReactGA.pageview(window.location.pathname);

  }
  //If required to fetch data from .json and load into App do it here

  componentDidMount(){
    //call services to perform client side code here

  }

  render() {
    return (
      <div className="App">
          <h4>{this.state.working}</h4>
      </div>
    );
  }
}

export default App;
