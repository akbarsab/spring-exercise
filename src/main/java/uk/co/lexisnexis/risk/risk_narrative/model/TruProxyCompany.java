package uk.co.lexisnexis.risk.risk_narrative.model;

import lombok.Data;

@Data
public class TruProxyCompany {
    private String companyNumber;
    private String companyType;
    private String title;
    private String companyStatus;
    private String dateOfCreation;
    private Address address;
}
