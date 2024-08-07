package uk.co.lexisnexis.risk.risk_narrative.model;

import lombok.Data;

import java.util.List;

@Data
public class CompanySearchResponse {
    private int totalResults;
    private List<Company> items;
}
