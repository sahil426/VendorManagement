package com.mswm.cloudathon.performancereviewer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mswm.cloudathon.performancereviewer.model.ContingentsRequest;
import com.mswm.cloudathon.performancereviewer.model.ProcessVendorResponse;
import com.mswm.cloudathon.performancereviewer.model.VendorInfo;
import com.mswm.cloudathon.performancereviewer.model.external.VendorsResponse;
import com.mswm.cloudathon.performancereviewer.util.MockData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContingentsInfoService {


    public ProcessVendorResponse getVendorInfo(ContingentsRequest contingentsRequest) {

        ProcessVendorResponse processVendorResponse = null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            VendorsResponse vendorsResponse = mapper.readValue(MockData.getVendorsData(), VendorsResponse.class);

            if (null != vendorsResponse) {
                processVendorResponse = new ProcessVendorResponse();

                if (vendorsResponse.getVendorsInfo().size() > 0) {

                    for (VendorInfo vendorInfo : vendorsResponse.getVendorsInfo()) {

                        if (vendorInfo.getLoginId().equalsIgnoreCase(contingentsRequest.getLoginId())) {

                            processVendorResponse.setVendorInfo(vendorInfo);
                        }
                    }


                }


            }


        } catch (Exception ex) {

            ex.printStackTrace();
        }


        return processVendorResponse;
    }
}
