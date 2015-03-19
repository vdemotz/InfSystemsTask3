package ch.ethz.globis.isk.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainJournalEdition;
import ch.ethz.globis.isk.domain.JournalEdition;
import ch.ethz.globis.isk.persistence.JournalEditionDao;

@Repository
public class MongoJournalEditionDao extends MongoDao<String, JournalEdition> implements JournalEditionDao {

    @Override
    protected Class<DomainJournalEdition> getStoredClass() {
        return DomainJournalEdition.class;
    }

    @Override
    public JournalEdition createEntity() {
        return new DomainJournalEdition();
    }

    @Override
    public List<JournalEdition> findByJournalIdOrdered(String journalId) {
        return null; //TODO
    }
}
