package pl.krystianzybala.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.krystianzybala.contract.controller.FraudDetectionController;
@RunWith(SpringRunner.class)
@SpringBootTest

public class BaseClass {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }
}
