"strict mode"

let APIKey = "RandomAssortmentOfLetters";
let tags = "";
let userAvgViews = "";
// Create XHR object
function createCORSRequest(method, url){
  let xhr = new XMLHttpRequest();
  xhr.open(method, url, true); 
  return xhr;
}

// Sends CORS Request when user searches for Tags
function onSearch(){
	tags = document.getElementById("tagsInput").value;
	userAvgViews = document.getElementByID("userAvgViews").value;
	makeCORSRequest();
}

// Makes CORS Request to imaginary API to get Youtube statistics based on video tags
function makeCORSRequest(){

	let url = "InsertURLHere" + tags + APIKey;
	let xhr = createCORSRequest('GET', url);

	if (!xhr) {
    alert('CORS not supported');
    return;
  }

  xhr.onload = function(){
  	let responseString = xhr.responseText;
  	let object = JSON.parse(responseString);
  	let avgViews = calcAvgViews(object.relevantJSONField);
  	let rate = avgViews / userAvgViews;
  	let rating = document.getElementByID("rating");
  	rating.textContent = rate;
  }

  xhr.onerror = function() {
    alert('Request error');
  };

  xhr.send();
}

// Helper functions for generating statistics from CORS Request

function calcAvgViews(object){
	let sum = 0;

	for(var i = 0; i < object.entries.length; i++){
		sum += object.entries[0].viewCount;
	}

	return sum / object.entries.length;

}
