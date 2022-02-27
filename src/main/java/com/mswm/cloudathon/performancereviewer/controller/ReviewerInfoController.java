package com.mswm.cloudathon.performancereviewer.controller;


import com.mswm.cloudathon.performancereviewer.manager.ReviewerInfoManager;
import com.mswm.cloudathon.performancereviewer.model.ReviewerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value= "/rest/reviewer/")
@Slf4j
public class ReviewerInfoController {

    private final ReviewerInfoManager reviewerInfoManager;

    @Autowired
    ReviewerInfoController(ReviewerInfoManager reviewerInfoManager){
        this.reviewerInfoManager = reviewerInfoManager;
    }


    @RequestMapping(value = "getContingents/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Object> getContingents(@PathVariable String id){

        final ResponseEntity<Object>  reviewerInfo = reviewerInfoManager.getContingents(id);
        return reviewerInfo;
    }
}
