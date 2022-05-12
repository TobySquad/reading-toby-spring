package com.example.jun.transaction.transactionmanager;


import com.example.jun.transaction.definition.TransactionDefinition;

public interface PlatformTransactionManagerz extends TransactionManagerz {
    void doBegin(TransactionDefinition definition);
}
