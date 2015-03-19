package ch.ethz.globis.isk.transaction;

import org.springframework.stereotype.Component;

@Component
public class MongoTransactionManager extends CacheAwareTransactionManager {

    @Override
    public void begin() {
    	//stub
    }

    @Override
    public void commit() {
    	//stub
    }

    @Override
    public void rollback() {
    	//stub
    }
}