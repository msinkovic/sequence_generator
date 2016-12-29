package com.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.domain.GeneratedData;
 
@Repository
public interface GeneratedDataRepository extends CrudRepository<GeneratedData, Long>{
}
