package com.example.repository;

import com.example.model.Book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}
