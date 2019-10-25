package com.javaxiaodi.springapi.service;

import com.javaxiaodi.springapi.entity.Prediction;
import com.javaxiaodi.springapi.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: TicketService
 * @packageName: service
 * @description: This is the service for Prediction
 * @data: 2019-10-25
 **/
@Service
public interface PredictionService {
    // Get predictions with the input
    int getPredict(String interest, String location, int comments, int ratings);
    // Find predictions in database
    List<Prediction> findByParameter(String interest, String location, int comments, int ratings);
    // Save the predictions
    void save(Prediction prediction);
}
