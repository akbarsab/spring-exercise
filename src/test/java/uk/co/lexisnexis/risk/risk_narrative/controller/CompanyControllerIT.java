package uk.co.lexisnexis.risk.risk_narrative.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebAppConfiguration
class CompanyControllerIT {

    private MockMvc mockMvc;
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void givenCompanyNumberPresentInDBSearchReturnJsonTypeContentWithCompanyDetails() {
        MvcResult mvcResult = this.mockMvc.perform(post("/Search"))
                .andExpect(status().isOk());

        //Also Mock and verify DB Repo

        assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
    }

    @Test
    void givenCompanyNumberNotPresentInDBSearchReturnJsonTypeContentFetchedFromTruNattaiveAPIWithCompanyDetails() {
        MvcResult mvcResult = this.mockMvc.perform(post("/Search"))
                .andExpect(status().isOk());

        //Also Mock and verify TruProxyService

        assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
    }
}