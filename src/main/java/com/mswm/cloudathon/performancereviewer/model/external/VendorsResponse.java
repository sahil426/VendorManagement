package com.mswm.cloudathon.performancereviewer.model.external;

import com.mswm.cloudathon.performancereviewer.model.VendorInfo;
import lombok.Data;

import java.util.List;

@Data
public class VendorsResponse {
    private List<VendorInfo> vendorsInfo;
}
