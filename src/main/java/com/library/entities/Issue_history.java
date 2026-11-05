package com.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issue_id;
    @ManyToOne
    @JoinColumn(name = "book_id" ,nullable = false)
    private int book_id;
    @ManyToOne
    @JoinColumn(name = "user_id" ,nullable = false)
    private int user_id;
    private LocalDateTime issue_time;
    private LocalDateTime return_time;
    private LocalDate expected_return_date;
    private String status;
    private float fine;
    private int issuer_id;

}
