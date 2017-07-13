package ba.infostudio;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class QuerySpecification<T> implements Specification<T> {

	public String queryColumnName;
	public String queryTerm;
	
	public QuerySpecification() {
	}
	
	public QuerySpecification(String queryColumnName, String queryTerm) {
		this.queryColumnName = queryColumnName;
		this.queryTerm = queryTerm;
	}
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Predicate predicate = builder.like(builder.upper(root.get(queryColumnName)), queryTerm);
        return predicate;
	}
	
	public String getQueryColumnName() {
		return queryColumnName;
	}

	public void setQueryColumnName(String queryColumnName) {
		this.queryColumnName = queryColumnName;
	}

	public String getQueryTerm() {
		return queryTerm;
	}

	public void setQueryTerm(String queryTerm) {
		this.queryTerm = queryTerm;
	}

}
