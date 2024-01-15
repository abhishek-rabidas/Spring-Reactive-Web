package com.abhishek.webfluxdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("record")
@Getter
@Setter
@NoArgsConstructor
public class Record {
    @Id
    @Column("id")
    private int id;

    @Column("details")
    private String details;

    @Column("savedOn")
    private LocalDate savedOn;

    public Record(RecordRequest request) {
        //this.id = request.getId();
        this.details = request.getDetails();
        this.savedOn = LocalDate.now();
    }
}
