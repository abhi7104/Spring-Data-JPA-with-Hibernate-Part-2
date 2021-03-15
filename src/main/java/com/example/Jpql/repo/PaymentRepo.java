package com.example.Jpql.repo;

import com.example.Jpql.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment,Integer> {
}
