package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.myReadList;

@Repository
public interface myBookRepository extends JpaRepository<myReadList, Integer>{

}
