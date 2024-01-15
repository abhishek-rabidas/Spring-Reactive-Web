package com.abhishek.webfluxdemo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends R2dbcRepository<Record, Integer> {
}
