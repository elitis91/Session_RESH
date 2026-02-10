package com.covea.simplecrudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covea.simplecrudapi.models.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

}
