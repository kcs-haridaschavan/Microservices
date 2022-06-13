package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kcsitglobal.model.BookRequest;

public interface BookMyShowRespository extends JpaRepository<BookRequest, Integer> {

}
