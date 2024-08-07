package uk.co.lexisnexis.risk.risk_narrative.model;

import lombok.Data;

import java.util.List;

@Data
public class TruProxyCompanySearchResponse {
    private int total_results;
    private List<TruProxyCompany> items;
}
