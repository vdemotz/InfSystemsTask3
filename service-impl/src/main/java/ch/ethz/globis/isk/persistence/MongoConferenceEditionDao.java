package ch.ethz.globis.isk.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.DomainConferenceEdition;
import ch.ethz.globis.isk.persistence.ConferenceEditionDao;

@Repository
public class MongoConferenceEditionDao extends MongoDao<String, ConferenceEdition> implements ConferenceEditionDao {

    @Override
    protected Class<DomainConferenceEdition> getStoredClass() {
        return DomainConferenceEdition.class;
    }

    @Override
    public ConferenceEdition createEntity() {
        return new DomainConferenceEdition();
    }

    @Override
    public List<ConferenceEdition> findByConferenceOrderedByYear(String conferenceId) {
    	//TODO
        return null;
    }
}