package uk.co.lexisnexis.risk.risk_narrative.model;

import lombok.Data;

@Data
public class CompanySearchRequest {
    private String companyName;
    private String companyNumber;
}
