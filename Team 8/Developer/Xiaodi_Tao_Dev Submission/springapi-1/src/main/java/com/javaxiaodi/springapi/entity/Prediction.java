package com.javaxiaodi.springapi.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: Xiaodi Tao
 * @className: Prediction
 * @packageName: entity
 * @description: This is the class for Prediction object
 * @data: 2019-10-25
 **/
@Entity
@Table(name = "Prediction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prediction {
    // Id should be automatically generated
    @Id
    @GeneratedValue
    private int id;
    private int result;
    private int ratings;
    private int comments;
    private String interest;
    private String location;
    // All the Setters and Getters
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getComments() {
        return comments;
    }
    public void setComments(int comments) {
        this.comments = comments;
    }
    public int getRatings() {
        return ratings;
    }
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }

}
