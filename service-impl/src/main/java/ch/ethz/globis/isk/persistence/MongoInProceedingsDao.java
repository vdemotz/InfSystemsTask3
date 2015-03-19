package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainInProceedings;
import ch.ethz.globis.isk.domain.InProceedings;
import ch.ethz.globis.isk.persistence.InProceedingsDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoInProceedingsDao extends MongoDao<String, InProceedings> implements InProceedingsDao {

    @Override
    public InProceedings findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<InProceedings> findByProceedingsIdOrderByYear(String proceedingsId) {
    	return null;
        //TODO return queryByReferenceIdOrderByYear("InProceedings", "proceedings", proceedingsId);
    }

    @Override
    protected Class<DomainInProceedings> getStoredClass() {
        return DomainInProceedings.class;
    }

    @Override
    public InProceedings createEntity() {
        return new DomainInProceedings();
    }

}