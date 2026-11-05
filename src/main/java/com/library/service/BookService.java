package com.library.service;

import com.library.dtos.BooksDTO;
import com.library.entities.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {

    List<Books> getBooks(int pageNum, String sortBy);
    Books getBookById(int id);
    Books addBook(BooksDTO booksDTO);
    String deleteBooks(int id);
    List<Books> searchBooks(String title, String author,String genre);
    Boolean checkavailability(int id);

}
