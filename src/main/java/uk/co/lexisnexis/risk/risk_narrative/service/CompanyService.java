package uk.co.lexisnexis.risk.risk_narrative.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.co.lexisnexis.risk.risk_narrative.entity.CompanyEntity;
import uk.co.lexisnexis.risk.risk_narrative.mapper.CompanyMapper;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchRequest;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchResponse;
import uk.co.lexisnexis.risk.risk_narrative.model.TruProxyCompanySearchResponse;
import uk.co.lexisnexis.risk.risk_narrative.repository.CompanyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    private CompanyRepository repository;
    private TruProxyService service;

    private CompanyMapper mapper;

    @Override
    public CompanySearchResponse findCompany(String apiKey, CompanySearchRequest request) {

        CompanySearchResponse response = new CompanySearchResponse();
        Optional<CompanyEntity> optionalCompany = repository.findById(request.getCompanyNumber());
        if (optionalCompany.isPresent()) {
            log.info("Company {} present in DB", request.getCompanyNumber());
            CompanyEntity companyEntity = optionalCompany.get();
            response.setItems(List.of(mapper.toCompany(companyEntity)));
        } else {
            ResponseEntity<TruProxyCompanySearchResponse> companySearchResponse = service.searchCompanies(apiKey, request);
            if( companySearchResponse.getStatusCode().is2xxSuccessful() ){
                response.setItems(companySearchResponse
                        .getBody()
                        .getItems()
                        .stream()
                        .filter( c -> c.getCompanyStatus() == "active" )
                        .map(mapper::toCompany)
                        .collect(Collectors.toList()));
                response.setTotalResults(companySearchResponse.getBody().getTotal_results());

                //Fetching Officers, filter resign and unions with active company
            }
        }

        return response;
    }
}
