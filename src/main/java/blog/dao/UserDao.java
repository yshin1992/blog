package blog.dao;

import blog.dao.Dao;
import blog.domain.User;

public interface UserDao extends Dao<User> {
	
	public User queryUser(String username,String passwd);
}
