package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainPublisher;
import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.persistence.PublisherDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoPublisherDao extends MongoDao<String, Publisher> implements PublisherDao {

    @Override
    protected Class<DomainPublisher> getStoredClass() {
        return DomainPublisher.class;
    }

    @Override
    public Publisher createEntity() {
        return new DomainPublisher();
    }

    @Override
    public Publisher findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}