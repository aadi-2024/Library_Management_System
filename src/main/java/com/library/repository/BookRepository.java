package com.library.repository;

import com.library.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public class BookRepository extends JpaRepository<Books,Integer> {

    public List<Books> findBytitle(String title) {
    }

    public List<Books> findByauthor(String author) {
    }

    public List<Books> findBygenre(String genre) {
    }
}
}
