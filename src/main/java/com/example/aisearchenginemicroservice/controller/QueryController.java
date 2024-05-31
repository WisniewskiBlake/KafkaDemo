package com.example.aisearchenginemicroservice.controller;

import com.example.aisearchenginemicroservice.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QueryController {

    private KafkaProducer kafkaProducer;

    @PostMapping("/search")
    public String search(@RequestBody QueryRequest queryRequest) {
        kafkaProducer.sendMessage(queryRequest.getQuery());
        return "Query sent to Kafka: " + queryRequest.getQuery();
    }
}

class QueryRequest {
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
