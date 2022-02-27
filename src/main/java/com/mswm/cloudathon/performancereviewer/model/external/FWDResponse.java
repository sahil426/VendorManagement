package com.mswm.cloudathon.performancereviewer.model.external;

import com.mswm.cloudathon.performancereviewer.model.People;
import lombok.Data;

import java.util.List;

@Data
public class FWDResponse

{
    private boolean fwdSuccess;
    private int reviewerSize;
    private List<People> people;
}
