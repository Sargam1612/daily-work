package com.zeta.demo.service;

import com.zeta.demo.entity.Book;
import com.zeta.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }
    public List<Book> findByAuthor(String author){
        return repository.findByAuthor(author);
    }

}