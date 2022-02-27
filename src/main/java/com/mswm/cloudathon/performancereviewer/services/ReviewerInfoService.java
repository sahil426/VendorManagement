package com.mswm.cloudathon.performancereviewer.services;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mswm.cloudathon.performancereviewer.model.People;
import com.mswm.cloudathon.performancereviewer.model.ProcessContingentResponse;
import com.mswm.cloudathon.performancereviewer.model.ReviewerRequest;
import com.mswm.cloudathon.performancereviewer.model.external.FWDResponse;
import com.mswm.cloudathon.performancereviewer.util.MockData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class ReviewerInfoService {


    public ProcessContingentResponse getContingents(String id) {

        ProcessContingentResponse processContingentResponse = null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            FWDResponse fwdResponse = mapper.readValue(MockData.getReviewInfoStrData(), FWDResponse.class);

            if (null != fwdResponse) {
                log.info("Inside getContingents with user {}",fwdResponse);
                processContingentResponse = new ProcessContingentResponse();

                processContingentResponse.setFwdSuccess(fwdResponse.isFwdSuccess());


                if (fwdResponse.getPeople().size() > 0) {
                    log.info("Inside getContingents with user {}",fwdResponse.getPeople().size());

                    for (People people : fwdResponse.getPeople()) {
                        log.info("Inside getContingents with user {}",people);
                        if (id.equalsIgnoreCase(people.getReviewerInfo().getUserId())) {

                            log.info("Inside getContingents with user {}", id);
                            processContingentResponse.setPeople(people);

                            break;

                        }

                    }


                }


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return processContingentResponse;
    }
}
