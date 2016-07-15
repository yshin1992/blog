package blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import blog.dao.ArticalTypeDao;
import blog.domain.ArticalType;
import blog.util.C3P0DBUtil;

public class ArticalTypeDaoImpl extends DaoAdapter<ArticalType> implements ArticalTypeDao {

	private static final Logger logger = Logger.getLogger(ArticalTypeDaoImpl.class);
	
	private static final String ARTICAL_TYPE_CREATE = "insert into artical_type(id,typeName,parentId) values(?,?,?);";
	
	private static final String ARTICAL_TYPE_QUERY_LIST = "select id,typeName,parentId from artical_type where parentId=?";
	
	private static final String ARTICAL_TYPE_QUERY_BY_ID = "select id,typeName,parentId from artical_type where id=?";
	
	private static final String ARTICAL_TYPE_DELETE = "delete from artical_type where id=?";
	
	/**
	 * 创建文章类型
	 */
	@Override
	public int create(ArticalType t) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int execRows = 0;
		try{
			con = C3P0DBUtil.getConnection();
			stmt = con.prepareStatement(ARTICAL_TYPE_CREATE);
			stmt.setString(1, t.getId());
			stmt.setString(2, t.getTypeName());
			stmt.setString(3, t.getParentId());
			execRows = stmt.executeUpdate();
		}catch(SQLException e)
		{
			logger.error("创建文章类型失败",e);
		}finally{
			C3P0DBUtil.attemptCloseAll(rs, stmt, con);
		}
		return execRows;
	}

	/**
	 * 批量创建
	 * @param typeList
	 * @return
	 */
	public boolean batchCreate(List<ArticalType> typeList)
	{
		if(null == typeList || typeList.size() == 0)
		{
			return false;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = C3P0DBUtil.getConnection();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(ARTICAL_TYPE_CREATE);
			for(ArticalType type : typeList)
			{
				stmt.setString(1, type.getId());
				stmt.setString(2, type.getTypeName());
				stmt.setString(3, type.getParentId());
				stmt.addBatch();
			}
			stmt.executeBatch();
			con.commit();
		}catch(SQLException e)
		{
			if(null != con)
			{
				try {
					con.rollback();
				} catch (SQLException e1) {
					logger.error("事务回滚失败",e1);
				}
			}
			logger.error("创建文章类型失败",e);
			return false;
		}finally{
			C3P0DBUtil.attemptCloseAll(null, stmt, con);
		}
		return true;
	}
	
	@Override
	public int update(ArticalType t) {
		
		return 0;
	}

	/**
	 * 删除文章类型
	 */
	public int delete(String id){
		int executeRows = 0;
		if(null == id){
			return executeRows;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try
		{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_TYPE_DELETE);
			pstm.setString(1, id);
			executeRows = pstm.executeUpdate();
		}catch(SQLException e)
		{
			logger.error("删除文章类型异常!"+id,e);
		}finally{
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
		return executeRows;
	}
	
	/**
	 * 遍历文章类型
	 */
	@Override
	public List<ArticalType> reverse(ArticalType t) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ArticalType> typeList = null;
		try{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_TYPE_QUERY_LIST);
			if(null == t)
			{
				pstm.setString(1, "-1");
			}else
			{
				pstm.setString(1, t.getId());
			}
			rs = pstm.executeQuery();
			typeList = new ArrayList<ArticalType>();	
			while(rs.next())
			{
				ArticalType type = new ArticalType();
				type.setId(rs.getString(1));
				type.setTypeName(rs.getString(2));
				type.setParentId(rs.getString(3));
				typeList.add(type);
			}
		}catch(SQLException e)
		{
			logger.error("遍历文章类型异常",e);
		}
		finally{
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return typeList;
	}

	/**
	 * 根据文章类型ID查询文章类型信息
	 * @param pk
	 * @return
	 */
	public ArticalType queryByPk(String pk) {
		// TODO Auto-generated method stub
		if(null == pk)
		{
			return null;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArticalType type = null;
		try{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_TYPE_QUERY_BY_ID);
			pstm.setString(1, pk);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				type = new ArticalType();
				type.setId(rs.getString(1));
				type.setTypeName(rs.getString(2));
				type.setParentId(rs.getString(3));
			}
		}catch(SQLException e)
		{
			logger.error("查找文章类型异常",e);
		}
		finally{
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return type;
	}

}
