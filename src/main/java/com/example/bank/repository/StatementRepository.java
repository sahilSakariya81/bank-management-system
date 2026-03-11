package com.example.bank.repository;

import com.example.bank.dto.StatementDTO;
import com.example.bank.model.StatementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatementRepository extends JpaRepository<StatementModel,Integer> {

    @Query(value = "SELECT * FROM statement where ac_no = ?1 ",nativeQuery = true)
    List<StatementModel> findAllByAcNo(Long acNo);
}
