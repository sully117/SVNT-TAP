package com.rating.youtube_rating.controller;
import com.rating.youtube_rating.repository.RatingRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatingController{
    private RatingRepository rating_repo;
    public RatingController(RatingRepository rating_repo){
        this.rating_repo=rating_repo;
    }

    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("repoList", rating_repo.findAll());
        return "index";
    }
    
}