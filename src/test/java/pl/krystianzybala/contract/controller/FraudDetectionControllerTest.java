package pl.krystianzybala.contract.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.krystianzybala.contract.ContractApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractApplication.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/docs")
public class FraudDetectionControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void shouldSendMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/message"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("message"));
    }
}