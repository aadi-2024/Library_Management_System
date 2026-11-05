package com.library.service;

import com.library.entities.Books;
import com.library.entities.Issue_history;

import java.util.List;

public interface IssueHistoryService {

     void issueBook(int bookId, int user_id);
     void returnBook(int bookId, int user_id,Issue_history issue_history);
     List<Issue_history>  getIssueHistory(int user_id);



}
