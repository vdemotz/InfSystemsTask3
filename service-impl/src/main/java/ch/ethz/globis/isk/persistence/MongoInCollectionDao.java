package ch.ethz.globis.isk.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Book;
import ch.ethz.globis.isk.domain.DomainInCollection;
import ch.ethz.globis.isk.domain.InCollection;
import ch.ethz.globis.isk.persistence.MongoPublicationDao.SortByYearAscendingComparator;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoInCollectionDao extends MongoDao<String, InCollection> implements InCollectionDao {

	@Autowired
	BookDao bookDao;
	
    @Override
    public InCollection findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<InCollection> findByBookIdOrderByYear(String bookId) {
    	Book book = bookDao.findOne(bookId);
        List<InCollection> pubs = new ArrayList<InCollection>(book.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
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