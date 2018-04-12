import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Send message"
    label "triggerFraud"
    input {
        triggeredBy("triggerMessage()")

    }

    outputMessage {
        sentTo "frauds"
        body([message: "Krystian send message!"])
    }
}