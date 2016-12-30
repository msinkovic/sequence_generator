package com.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.domain.GeneratedData;
 
@Repository
public interface GeneratedDataRepository extends JpaRepository<GeneratedData, Long>{
}
