package ch.ethz.globis.isk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Article;
import ch.ethz.globis.isk.domain.DomainArticle;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoArticleDao extends MongoDao<String, Article> implements ArticleDao {

    @Override
    protected Class<DomainArticle> getStoredClass() {
        return DomainArticle.class;
    }

    @Override
    public Article createEntity() {
        return new DomainArticle();
    }

    @Override
    public Article findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<Article> findByJournalEditionOrderedByYear(String journalEditionId) {
        //return queryByReferenceIdOrderByYear("Article", "journalEdition", journalEditionId);
    	return null;
    }
}