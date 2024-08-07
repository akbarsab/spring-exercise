package uk.co.lexisnexis.risk.risk_narrative.service;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.lexisnexis.risk.risk_narrative.config.TruNarrativeConfig;
import uk.co.lexisnexis.risk.risk_narrative.model.CompanySearchRequest;
import uk.co.lexisnexis.risk.risk_narrative.model.TruProxyCompanySearchResponse;
import uk.co.lexisnexis.risk.risk_narrative.model.TruProxyOfficerSearchResponse;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class TruProxyService {

    @Value("${truproxy.baseUrl}")
    String baseUrl;


    public ResponseEntity<TruProxyCompanySearchResponse> searchCompanies(String apiKey, CompanySearchRequest request) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "v1/Search").queryParam("Query",request.getCompanyNumber());

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity <String> entity = new HttpEntity<String>(headers);

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-api-key", apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            log.info("Hitting TruProxy API with url: " + builder.build().toUri() + " and headers: " + headers);
            return restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    entity,
                    TruProxyCompanySearchResponse.class
            );
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<TruProxyOfficerSearchResponse> searchOfficers(String apiKey, CompanySearchRequest request) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "v1/Officer").queryParam("CompanyName",request.getCompanyNumber());

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity <String> entity = new HttpEntity<String>(headers);

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-api-key", apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            log.info("Hitting TruProxy API with url: " + builder.build().toUri() + " and headers: " + headers);
            return restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    entity,
                    TruProxyOfficerSearchResponse.class
            );
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
