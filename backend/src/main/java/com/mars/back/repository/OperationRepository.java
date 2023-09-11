package com.mars.back.repository;

import com.mars.back.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository <Operation, Long>{
}
