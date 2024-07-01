package com.crick.apis.Controller;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.Match;
import com.crick.apis.Service.FeaturedMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
public class FeaturedMatchController {
    @Autowired
    FeaturedMatchService featuredMatchService;

    @GetMapping("/featured-match")
    public ResponseEntity<List<FeaturedMatch>> getAllFeaturedMatch(){
        return new ResponseEntity<>(this.featuredMatchService.getAllFeaturedMatch(), HttpStatus.OK);
    }
}
