package com.nisum.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.crud.model.Phone;
import com.nisum.crud.model.User;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	List<Phone> findByUser(User userStoraged);

}
