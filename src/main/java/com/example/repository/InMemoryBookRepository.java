package com.example.repository;

import com.example.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository{
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
        books.put("1", new Book("1","Book1","Василий Панин"));
        books.put("2", new Book("2","Book2","Иван Гулько"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
