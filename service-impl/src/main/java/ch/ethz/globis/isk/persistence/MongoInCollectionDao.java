package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainInCollection;
import ch.ethz.globis.isk.domain.InCollection;
import ch.ethz.globis.isk.persistence.InCollectionDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoInCollectionDao extends MongoDao<String, InCollection> implements InCollectionDao {

    @Override
    public InCollection findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<InCollection> findByBookIdOrderByYear(String bookId) {
    	return null;
        //TODO return queryByReferenceIdOrderByYear("InCollection", "parentPublication", bookId);
    }

    @Override
    protected Class<DomainInCollection> getStoredClass() {
        return DomainInCollection.class;
    }

    @Override
    public InCollection createEntity() {
        return new DomainInCollection();
    }

}