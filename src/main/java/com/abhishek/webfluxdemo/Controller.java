package com.abhishek.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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

    @GetMapping(value = "/getAll/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Record> getAllRecordsStream() {
        return recordRepository.findAll().delayElements(Duration.ofMillis(100));
    }

   /* var evtSource = new EventSource("http://localhost:8080/getAll/stream");
   * evtSource.onmessage = function (event) {
   *    console.log(JSON.parse(event.data).details)
   * }
   *
   * */

}
