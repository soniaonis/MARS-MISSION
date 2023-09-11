package com.mars.back.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "calculations")
@Data
@CrossOrigin(origins = "*")

public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int operand1;
    @Column
    private int operand2;
    @Column
    private String operator;
    @Column
    private int result;

    public Operation() {
    }

    public Operation(Long id, int operand1, int operand2, String operator, int result) {
        this.id = id;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
    }
}
