package blog.dao;

import blog.domain.ArticalType;

public interface ArticalTypeDao extends Dao<ArticalType> {
	
	int delete(String id);
}
