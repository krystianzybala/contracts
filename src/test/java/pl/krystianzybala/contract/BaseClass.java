package pl.krystianzybala.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;
import pl.krystianzybala.contract.controller.FraudDetectionController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    FraudDetectionController fraudDetectionController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(fraudDetectionController);
    }

    public void triggerMessage() {

        this.fraudDetectionController.message();
    }
}
