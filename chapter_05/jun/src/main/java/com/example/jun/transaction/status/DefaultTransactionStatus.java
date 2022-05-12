package com.example.jun.transaction.status;

public class DefaultTransactionStatus extends AbstractTransactionStatus {

    private final boolean valid;
    private final boolean synchronization;

    public DefaultTransactionStatus() {
        this.valid = true;
        this.synchronization = true;
    }

    @Override
    public boolean isNewTransaction() {
        return false;
    }

    @Override
    public void setRollbackOnly() {

    }

    @Override
    public boolean isRollbackOnly() {
        return false;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public boolean hasSavePoint() {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public String toString() {
        return ""+valid;
    }
}
