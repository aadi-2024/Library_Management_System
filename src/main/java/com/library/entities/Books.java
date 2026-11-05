package com.library.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int book_id;
 private String title;
 private String author;
 private String genre;
 private int qty;
 private boolean available;
 private String status;
 private LocalDateTime next_available;
}
