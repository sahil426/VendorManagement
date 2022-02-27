package com.mswm.cloudathon.performancereviewer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewerInfo {

    private String departmentDesc;
    private Boolean isAdmin;
    private String emailAddress;
    private String photoURL;
    private String fullName;
    private String userId;
    private String mobile;
    private List<ContingentsInfo> contingents;
}
