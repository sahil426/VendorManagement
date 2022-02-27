package com.mswm.cloudathon.performancereviewer.controller;


import com.mswm.cloudathon.performancereviewer.manager.ContingentsInfoManager;
import com.mswm.cloudathon.performancereviewer.model.ContingentsRequest;
import com.mswm.cloudathon.performancereviewer.model.ReviewerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/rest/contingents/")
@Slf4j
public class ContingentsInfoController {

    private final ContingentsInfoManager contingentsInfoManger;

    @Autowired
    ContingentsInfoController(ContingentsInfoManager contingentsInfoManger){
        this.contingentsInfoManger = contingentsInfoManger;
    }


    @RequestMapping(value = "getVendorInfo", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Object> getVendorInfo(@RequestBody ContingentsRequest contingentsRequest){

        final ResponseEntity<Object>  vendorInfo = contingentsInfoManger.getVendorInfo(contingentsRequest);
        return vendorInfo;
    }

}
