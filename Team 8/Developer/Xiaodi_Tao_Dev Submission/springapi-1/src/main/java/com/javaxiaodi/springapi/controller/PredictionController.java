package com.javaxiaodi.springapi.controller;

import com.javaxiaodi.springapi.entity.Message;
import com.javaxiaodi.springapi.entity.Prediction;
import com.javaxiaodi.springapi.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: PredictionController
 * @packageName: controller
 * @description: This is the class for api related with predictions
 * @data: 2019-10-25
 **/
@RestController
@RequestMapping("/prediction")
public class PredictionController {
	@Autowired
	PredictionService predictionService;

	// It will shows the prediction result as the user gives the input
	@PostMapping("/getPredictions")
		public Message getPredictions (@RequestParam("interest") String interest,
									   @RequestParam("location") String location,
									   @RequestParam("comments") int comments,
									   @RequestParam("ratings") int ratings) {
			Message message = new Message();
			//Validate the form, when it has empty input
			if(interest.isEmpty()||location.isEmpty()){
				message.setCode(400);
				message.setMessageDetails("The interest and location should not be empty");
				return message;
			}
			List<Prediction> predictions = predictionService.findByParameter(interest, location, comments, ratings);
			if(predictions.size() > 0) {
				message.setCode(200);
				message.setValue(predictions.get(0).getResult());
			}
			if(predictions.size() == 0) {
				message.setCode(200);
				message.setValue(0);
				Prediction prediction = new Prediction();
				prediction.setInterest(interest);
				prediction.setComments(comments);
				prediction.setLocation(location);
				prediction.setRatings(ratings);
				prediction.setResult(0);
				predictionService.save(prediction);
				message.setCode(200);
				message.setValue(0);
			}
			return message;
		}

}
