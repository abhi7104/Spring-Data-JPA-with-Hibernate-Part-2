package com.example.Jpql.repo;

import com.example.Jpql.entity.Employeemapping;
import org.springframework.data.repository.CrudRepository;

public interface ComponentMappingRepo extends CrudRepository<Employeemapping,Integer> {
}
