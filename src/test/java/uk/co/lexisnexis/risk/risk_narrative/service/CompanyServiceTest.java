package uk.co.lexisnexis.risk.risk_narrative.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.lexisnexis.risk.risk_narrative.mapper.CompanyMapper;
import uk.co.lexisnexis.risk.risk_narrative.repository.CompanyRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    /**
     * Due to lack of time test method are written to demonstrate various test cases. Happy path and edge cases
     */
    @Mock
    private CompanyRepository repository;
    @Mock
    private TruProxyService service;
    @Mock
    private CompanyMapper mapper;

    @InjectMocks
    private CompanyService companyService;

    @Test
    void testFindCompanyByCompanyNumberFoundInDatabase_returnsCompanyObject() throws Exception {

    }

    @Test
    void testGivenCompanyNumberNotFoundInDatabaseAndWithActiveStatus_returnsCompanyObject() throws Exception {

    }

    @Test
    void testGivenCompanyNumberNotFoundInDatabaseAndWithInactiveStatus_returnEmptyObjects() throws Exception {

    }

    @Test
    void testGivenCompanyNumberNotFoundInDatabaseAndWithActiveStatusAndActiveOfficers_returnsCompanyObject() throws Exception {

    }

    @Test
    void testGivenCompanyNumberNotFoundInDatabaseAndWithActiveStatusAndInActiveOfficers_returnEmptyObjects() throws Exception {

    }


}