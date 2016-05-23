package blog.dao;

import java.util.List;

/**
 * Dao接口
 * @author Administrator
 *
 * @param <T>
 */
public interface Dao<T> {
	
	public int create(T t);
	
	public int update(T t);
	
	public List<T> reverse(T t);
	
	public T queryByPk(Integer pk);
}
