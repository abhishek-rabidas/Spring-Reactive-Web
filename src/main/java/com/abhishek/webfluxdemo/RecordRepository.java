package com.abhishek.webfluxdemo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends ReactiveCrudRepository<Record, Integer> {
}
