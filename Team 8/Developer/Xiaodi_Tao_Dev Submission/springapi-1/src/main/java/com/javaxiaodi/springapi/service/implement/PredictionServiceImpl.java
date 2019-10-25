package com.javaxiaodi.springapi.service.implement;

import com.javaxiaodi.springapi.entity.Prediction;
import com.javaxiaodi.springapi.repository.PredictRepository;
import com.javaxiaodi.springapi.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: TicketServiceImpl
 * @packageName: service.implement
 * @description: This is the implementation for TicketService
 * @data: 2019-10-25
 **/
@Component
public class PredictionServiceImpl implements PredictionService {
    @Autowired
    PredictRepository predictRepository;

    // Get predictions with the input
    @Override
    public int getPredict(String interest, String location, int comments, int ratings){
        // waiting for Data Scientist to add prediction logic here
        return 0;
    }
    // Find predictions in database
    @Override
    public List<Prediction> findByParameter(String interest, String location, int comments, int ratings){
        return predictRepository.findByParameter(interest,location,comments,ratings);
    }
    // Save the prediction
    @Override
    public void save(Prediction prediction){
        predictRepository.save(prediction);
    }
}
