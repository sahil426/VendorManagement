package com.mswm.cloudathon.performancereviewer.manager;


import com.mswm.cloudathon.performancereviewer.model.ContingentsRequest;
import com.mswm.cloudathon.performancereviewer.model.ProcessContingentResponse;
import com.mswm.cloudathon.performancereviewer.model.ProcessVendorResponse;
import com.mswm.cloudathon.performancereviewer.services.ContingentsInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContingentsInfoManager {

    @Autowired
    private final ContingentsInfoService contingentsInfoService;

    @Autowired
    public ContingentsInfoManager(ContingentsInfoService contingentsInfoService){
        this.contingentsInfoService = contingentsInfoService;
    }

    /**
     * This methos will take list of Contigents and return their info
     * @return
     */

    public ResponseEntity<Object> getVendorInfo(ContingentsRequest contingentsRequest){

        ProcessVendorResponse processVendorResponse = contingentsInfoService.getVendorInfo(contingentsRequest);
        return new ResponseEntity<>(processVendorResponse, HttpStatus.OK);
    }

}
