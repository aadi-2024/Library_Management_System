package com.library.service;

import com.library.dtos.BooksDTO;
import com.library.entities.Books;
import com.library.repository.BookRepository;
import com.library.util.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookrepo;

    @Override
    public List<Books> getBooks(int pageNum, String sortBy) {

        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(0, 10, sort);
        return bookrepo.findAll(pageable).getContent();
    }

    @Override
    public Books getBookById(int id) {
       return bookrepo.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found"));
    }



    @Override
    public Books addBook(BooksDTO booksDTO)
    {

      Books book = Books.builder().title(booksDTO.getTitle()).author(booksDTO.getAuthor()).genre(booksDTO.getGenre()).qty(booksDTO.getQty()).available(booksDTO.getQty()).status(booksDTO.getStatus()).next_available(booksDTO.getNext_available()).build();
      return bookrepo.save(book);
    }

    @Override
    public String deleteBooks(int id) {
        if(bookrepo.findById(id)!= null)
        {
            bookrepo.deleteById(id);
            return "Book Deleted Successfully by Id: "+id;
        }
        else
            {
            return "Book Not Found";
            }

    }

    @Override
    public List<Books> searchBooks(String title, String author, String genre) {

        if (title !=null && title.isEmpty())
        {
            return bookrepo.findBytitle(title);
        }

        if (author !=null && author.isEmpty())
        {
            return bookrepo.findByauthor(author);
        }
        if (genre !=null && genre.isEmpty())
        {
            return bookrepo.findBygenre(genre);
        }

        return getBooks(0,title);
    }

    @Override
    public Boolean checkavailability(int id) {
       Books book =  bookrepo.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found"));
       if (book.getAvailable() > 0)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

}
