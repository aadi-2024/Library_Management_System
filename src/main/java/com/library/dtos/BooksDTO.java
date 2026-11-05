package com.library.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BooksDTO {

    private int book_id;
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "author is required")
    private String author;
    @NotBlank(message = "genre is required")
    private String genre;
    @NotBlank(message = "qty is required")
    private int qty;
    private int available;
    private String status;
    private LocalDateTime next_available;
}
