//const dataset_model = require('/location_of_model_access') // (FAKE MODEL LIBRARY)

class Model {
    async predict(features){ 
        // The real predict would call the dataset_model and run the prediction and wait for result:
        // const prediction = await dataset_model.predict(features);
        // return prediction;


        // [REAL IMPLEMENTATION WOULD BE STH LIKE ABOVE]
        // For now, I am just mocking a constant value for now and sending response right away
        const response = {
            views: 1234567,
            title: "longer",
            comments: "enabled",
            ratings: "enabled"
        };
        //await fakeTimeout = await setTimeout(resolve, 1000));
        return response;
    } 
}

module.exports.Model = Model;
module.exports.predict = Model.predict;