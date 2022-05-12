package com.example.jun.transaction.status;

/**
 * 클래스가 너무 많아져서 간략화
 */
public interface TransactionStatus {

    boolean isNewTransaction();

    void setRollbackOnly();

    boolean isRollbackOnly();

    boolean isCompleted();

    boolean hasSavePoint();

    void flush();
}
