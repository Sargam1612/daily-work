package com.zeta.demo.controller;

import com.zeta.demo.entity.Book;
import com.zeta.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping("/author/{name}")
    public List<Book> byAuthor (@PathVariable String name){
        return service.findByAuthor(name);
    }
}
