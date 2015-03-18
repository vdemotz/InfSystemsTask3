package ch.ethz.globis.isk.transaction;

import org.springframework.stereotype.Component;

@Component
public class MongoTransactionManager extends CacheAwareTransactionManager {

    @Override
    public void begin() {
    }

    @Override
    public void commit() {
    }

    @Override
    public void rollback() {
    }
}