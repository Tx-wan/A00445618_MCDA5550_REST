package com.twan.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twan.framework.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
