import React, { Component } from 'react';
import axios from 'axios';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
        topTags: []
    };


}
componentDidMount() {
  axios.get('/api/tags').then((response) => {
  
    this.processData(response.data);
  })
}

processData(data) {
  /*
  Tags: views
  */
  let tagsCount = {

  }

  for (let x = 0 ;x < data.length; x++) {
    
    let tags = data[x].tags.toLowerCase().split('|');
    for (let i = 0;  i < tags.length; i++) {
      let tag = tags[i];
    
      
      if (tagsCount[tag] === undefined) {
        tagsCount[tag]= {'views': data[x].views, 'likes': data[x].likes};
        
      } else {
        tagsCount[tag].views += data[x].views;
        tagsCount[tag].likes += data[x].likes;
      }
    }
  }
  console.log(tagsCount);
  /*Return list of tags with view count and likes */
  
  
}
  
 
  render() {
    return (
      <div>
        
      </div>
    );
  }
}

export default App;