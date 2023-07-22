package com.sctp.module3project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sctp.module3project2.entity.BookingDateTime;

public interface BookingDateTimeRepository extends JpaRepository<BookingDateTime, Long>{
  
}

