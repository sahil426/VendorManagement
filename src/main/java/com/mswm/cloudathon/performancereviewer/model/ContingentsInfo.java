package com.mswm.cloudathon.performancereviewer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContingentsInfo {
    private String emailAddress;
    private String fullName;
    private String mobilePhone;
    private String userId;
    private String reviewStatus;
    private String reviewedOn;
}
