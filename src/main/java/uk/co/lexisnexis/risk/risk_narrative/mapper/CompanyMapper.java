package uk.co.lexisnexis.risk.risk_narrative.mapper;

import org.springframework.stereotype.Component;
import uk.co.lexisnexis.risk.risk_narrative.entity.CompanyEntity;
import uk.co.lexisnexis.risk.risk_narrative.model.Company;
import uk.co.lexisnexis.risk.risk_narrative.model.TruProxyCompany;

@Component
public class CompanyMapper {

    public Company toCompany(CompanyEntity entity){
        return Company.builder()
                .companyNumber(entity.getCompanyNumber())
                .companyStatus(entity.getCompanyStatus())
                .companyType(entity.getCompanyType())
                .build();
    }

    public Company toCompany(TruProxyCompany company){
        return Company.builder()
                .companyNumber(company.getCompanyNumber())
                .companyStatus(company.getCompanyStatus())
                .companyType(company.getCompanyType())
                .build();
    }
}
