package com.twan.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twan.framework.entity.Guest;

@Repository
public interface  GuestRepository extends JpaRepository<Guest, Long>{

	@Query(nativeQuery = true, value = "select gtl.guest_id from guest_tbl gtl where gtl.first_name = ?1 and gtl.last_name = ?2")
	public long findIdByName(String firstname, String lastname);
}
