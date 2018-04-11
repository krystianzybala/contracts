package pl.krystianzybala.contract.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudDetectionController {

    @PutMapping(path = "/fraudcheck", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response check(final Fraud fraud) {


        return new Response("FRAUD", "Amount too high");
    }

    @AllArgsConstructor
    @Data
    public static class Fraud {
        private String clientId;
        private Long loanAmount;
    }



}
@AllArgsConstructor
@Data
class Response {
    private String fraudCheckStatus;
    private String rejectionReason;
}