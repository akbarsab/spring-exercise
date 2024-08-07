package uk.co.lexisnexis.risk.risk_narrative.controller;

import org.springframework.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchRequest;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchResponse;
import uk.co.lexisnexis.risk.risk_narrative.service.ICompanyService;

@Slf4j
@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

    @PostMapping("/search")
    public ResponseEntity<CompanySearchResponse> searchCompanies(@RequestHeader(value = "x-api-key") String apiKey,
                                                                 final @RequestBody CompanySearchRequest request) throws Exception {

        log.info("Received request {}", request);

        if(!StringUtils.hasLength(apiKey) || ( !StringUtils.hasLength(request.getCompanyName()) && !StringUtils.hasLength(request.getCompanyName()))){
            return ResponseEntity.badRequest().build();
        }

        CompanySearchResponse response = companyService.findCompany(apiKey, request);
        return ResponseEntity.ok(response);
    }
}
