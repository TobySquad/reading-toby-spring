package com.example.jun.transaction.transactionmanager;

import com.example.jun.transaction.definition.TransactionDefinition;
import com.example.jun.transaction.exception.TransactionEx;
import com.example.jun.transaction.status.TransactionStatus;

public interface TransactionManagerz {
    TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionEx;

    void commit(TransactionStatus status) throws TransactionEx;

    void rollback(TransactionStatus status) throws TransactionEx;

}
