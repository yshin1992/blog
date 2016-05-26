package blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import blog.dao.UserDao;
import blog.domain.User;
import blog.util.C3P0DBUtil;
import blog.util.StringUtil;

/**
 * UserDao 实现类
 * 
 * @author Administrator
 *
 */
public class UserDaoImpl extends DaoAdapter<User> implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	private static final String QUERY_USER_BY_UP = "select id,roleId,createTime,status from user where loginName=? and passwd=?";

	@Override
	public User queryUser(String username, String passwd) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(QUERY_USER_BY_UP);
			pstm.setString(1, username);
			pstm.setString(2, StringUtil.generateMD5String(passwd));
			rs = pstm.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setRoleId(rs.getShort(2));
				user.setCreateTime(rs.getDate(3));
				user.setStatus(rs.getBoolean(4));
				user.setLoginName(username);
				logger.debug("查询用户信息成功:"+user);
			}
		} catch (SQLException e) {
			logger.error("查询用户信息失败 !", e);
		} finally {
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return user;
	}

}
