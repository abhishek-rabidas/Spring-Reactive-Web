package com.abhishek.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @Autowired
    private RecordRepository recordRepository;

    @PostMapping(value = "/save", consumes = "application/stream+json")
    public Mono<?> saveRecord(@RequestBody RecordRequest request) {
        return recordRepository.save(new Record(request));
    }

    @GetMapping("/getAll")
    public Flux<?> getAllRecords() {
        return recordRepository.findAll();
    }

    @GetMapping(value = "/getAll/stream", produces = "application/stream+json")
    public Flux<?> getAllRecordsStream() {
        return recordRepository.findAll();
    }

}
