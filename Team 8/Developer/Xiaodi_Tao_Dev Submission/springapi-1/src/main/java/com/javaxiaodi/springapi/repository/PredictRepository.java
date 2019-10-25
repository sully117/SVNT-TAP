package com.javaxiaodi.springapi.repository;//package com.javatechie.spring.mysql.api.dao;

import com.javaxiaodi.springapi.entity.Prediction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: PredictRepository
 * @packageName: repository
 * @description: This is the repository for Prediction
 * @data: 2019-10-25
 **/
public interface PredictRepository extends CrudRepository<Prediction, Integer>{
    // The method find the result prediction in the database
    @Query(value = "select * from prediction where interest=?1 and location=?2 and comments=?3 and " +
            "ratings = ?4", nativeQuery = true)
    List<Prediction> findByParameter(String interest, String location, int comments, int ratings);
}
