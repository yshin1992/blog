package blog.dao.impl;

import java.util.List;

import blog.dao.Dao;

/**
 * Dao适配器类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class DaoAdapter<T> implements Dao<T> {

	@Override
	public int create(T t) {
		return 0;
	}

	@Override
	public int update(T t) {
		return 0;
	}

	@Override
	public List<T> reverse(T t) {
		return null;
	}

	@Override
	public T queryByPk(Integer pk) {
		return null;
	}

}
