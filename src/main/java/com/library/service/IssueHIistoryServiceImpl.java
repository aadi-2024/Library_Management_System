package com.library.service;

import com.library.entities.Books;
import com.library.entities.Issue_history;
import com.library.entities.User;
import com.library.repository.BookRepository;
import com.library.repository.IssueHistoryRepository;
import com.library.repository.UserRepository;
import com.library.util.BookNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;


public class IssueHIistoryServiceImpl implements IssueHistoryService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    IssueHistoryRepository issuerepo;

    private static final Logger Logger = (Logger) LoggerFactory.getLogger(IssueHIistoryServiceImpl.class);

    @Override
    public void issueBook(int bookId, int user_id) {
       Books book = bookRepo.findById(bookId).orElseThrow(()->new BookNotFoundException("Book not found with id"));
       if(!book.isAvailable()){
           throw new RuntimeException("Book is not available Please try again later");
       }

        User user = userRepo.findById(user_id).orElseThrow(()-> new RuntimeException("User not found with id"));

       Issue_history new_issue = Issue_history.builder().book_id(bookId).user_id(user_id).issue_time(LocalDateTime.now()).expected_return_date(LocalDate.now().plusDays(15)).status("pending").fine(0).issuer_id(2).build();
    }

    @Override
    public void returnBook(int bookId, int user_id,Issue_history issue_history) {

    }

    @Override
    public List<Issue_history> getIssueHistory(int user_id) {
        return List.of();
    }
}
