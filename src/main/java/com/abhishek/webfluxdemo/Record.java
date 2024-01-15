package com.abhishek.webfluxdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Date;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Record {
    @Id
    private int id;
    private String details;
    private Date date;

    public Record(RecordRequest request) {
        this.id = request.getId();
        this.details = request.getDetails();
        this.date = new Date();
    }
}
