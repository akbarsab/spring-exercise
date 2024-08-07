package uk.co.lexisnexis.risk.risk_narrative.service;

import org.springframework.stereotype.Service;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchRequest;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchResponse;

public interface ICompanyService {
    CompanySearchResponse findCompany(String apiKey, CompanySearchRequest request);
}
