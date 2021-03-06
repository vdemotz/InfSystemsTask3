package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainJournal;
import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.persistence.JournalDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoJournalDao extends MongoDao<String, Journal> implements JournalDao {

    @Override
    protected Class<DomainJournal> getStoredClass() {
        return DomainJournal.class;
    }

    @Override
    public Journal findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }

    @Override
    public Journal createEntity() {
        return new DomainJournal();
    }
}