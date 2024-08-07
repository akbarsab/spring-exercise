package uk.co.lexisnexis.risk.risk_narrative.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    String locality;
    String postalCode;
    String premises;
    String addressLine_1;
    String country;
}
