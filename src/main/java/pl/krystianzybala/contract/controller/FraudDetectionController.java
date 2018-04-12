package pl.krystianzybala.contract.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudDetectionController {

    private final Source source;

    public FraudDetectionController(final Source source) {
        this.source = source;
    }

    @PutMapping(path = "/fraudcheck", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response check(final Fraud fraud) {
        return new Response("FRAUD", "Amount too high");
    }

    @PostMapping(path = "/message")
    public void message() {
        this.source.output().send(MessageBuilder
        .withPayload(
                new FraudMessage("Krystian send message!")
        )
        .build());
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

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
class FraudMessage {
    private String message;
}
