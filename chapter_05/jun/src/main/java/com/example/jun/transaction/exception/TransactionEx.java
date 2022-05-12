package com.example.jun.transaction.exception;

import lombok.Getter;

@Getter
public class TransactionEx extends RuntimeException {

    private static final String TRACSACTION_EXCEPTION = "트랜잭션 중 발생하는 Runtime 예외";

    private String message;

    public TransactionEx() {
        this.message = TRACSACTION_EXCEPTION;
    }
}
