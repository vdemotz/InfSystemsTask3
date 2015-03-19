package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.DomainPublication;
import ch.ethz.globis.isk.domain.Publication;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoPublicationDao extends MongoDao<String, Publication> implements PublicationDao {

    @Override
    protected Class<DomainPublication> getStoredClass() {
        return DomainPublication.class;
    }

    @Override
    public Publication createEntity() {
        return new DomainPublication();
    }

    @Override
    public Publication findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<Publication> findByAuthorIdOrderedByYear(String authorId) {
        //TODO return queryByReferenceIdOrderByYear("Publication", "authors", authorId);
    	return null;
    }

    @Override
    public List<Publication> findByEditorIdOrderedByYear(String editorId) {
    	return null;
        //TODO return queryByReferenceIdOrderByYear("Publication", "editors", editorId);
    }

    @Override
    public List<Publication> findByPublisherOrderedByYear(String publisherId) {
    	return null;
        //TODO return queryByReferenceIdOrderByYear("Publication", "publisher", publisherId);
    }

    @Override
    public List<Publication> findBySchoolOrderedByYear(String schoolId) {
        //TODO return queryByReferenceIdOrderByYear("Publication", "school", schoolId);
    	return null;
    }

    @Override
    public List<Publication> findBySeriesOrderedByYear(String seriesId) {
    	//TODO return queryByReferenceIdOrderByYear("Publication", "series", seriesId);
    	return null;
    }
}