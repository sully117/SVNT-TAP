const express = require('express')
var bodyParser = require('body-parser')
const app = express()
const port = 3000
const Model = require('./fake_model_predictor').Model

// parse JSON (application/json content-type)
app.use(bodyParser.json())

app.get('/', (req, res) => res.send('Hello World!'))

app.post('/insights', async (req, res) => {
    console.log("data: ", req.body)

    // Do any data preparation and build object according to what the model predictor expects
    // For now, I am just sending it as-is. (No changes)
    let input = req.body;

    // run prediction on trained model
    let model = new Model();
    const prediction = await model.predict(input);

    //return res.send('Received a POST HTTP method')
    // return updated list
   res.json(prediction)
  });

app.listen(port, () => console.log(`Example app listening on port ${port}!`))