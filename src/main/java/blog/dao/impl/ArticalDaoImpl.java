package blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import blog.dao.ArticalDao;
import blog.domain.Artical;
import blog.util.C3P0DBUtil;
import blog.util.StringUtil;
import blog.vo.ArticalVO;

public class ArticalDaoImpl extends DaoAdapter<Artical> implements ArticalDao {

	private static final Logger log = Logger.getLogger(ArticalDaoImpl.class);
	
	private static final String ARTICAL_CREATE = "insert into artical(authorId,typeId,title,content,createTime) values(?,?,?,?,?);";
	
	private static final String ARTICAL_QUERY_ALL = "SELECT a.id,authorId,typeId,title,content,a.createTime,u.loginName,t.typeName FROM artical a left join user u on u.id=authorId left join artical_type t on t.id=typeId";
	
	private static final String ARTICAL_QUERY_BY_ID = ARTICAL_QUERY_ALL + " where a.id = ?";
	/**
	 * 创建文章
	 * @param artical 文章
	 */
	@Override
	public int create(Artical artical) {
		Connection con=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int genKey = -1;
		try{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_CREATE,PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setInt(1,artical.getAuthorId());
			pstm.setString(2, artical.getTypeId());
			pstm.setString(3, artical.getTitle());
			pstm.setString(4, artical.getContent());
			pstm.setTimestamp(5, artical.getCreateTime());
			int excuteRows = pstm.executeUpdate();
			if(excuteRows > 0)
			{
				rs = pstm.getGeneratedKeys();
				if(rs.next()){
					genKey = rs.getInt(1);
				}
			}
		}catch(Exception e){
			log.error("创建文章失败!",e);
		}finally{
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return genKey;
	}

	@Override
	public int update(Artical artical) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 分页读取文章
	 */
	public List<ArticalVO> queryByPage(){
		//TODO
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ArticalVO> articalList = new ArrayList<ArticalVO>();
		try{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_QUERY_ALL);
			rs = pstm.executeQuery();
			while(rs.next()){
				ArticalVO vo = new ArticalVO();
				vo.setId(rs.getInt(1));
				vo.setAuthorId(rs.getInt(2));
				vo.setTypeId(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(StringUtil.htmlSpecialChars(rs.getString(5)));
				vo.setCreateTime(rs.getTimestamp(6));
				vo.setAuthorName(rs.getString(7));
				vo.setTypeName(rs.getString(8));
				articalList.add(vo);
			}
		}catch(Exception e){
			log.error("分页查询文章列表失败!");
		}finally{
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return articalList;
	}

	/**
	 * 根据文章ID查询文章的详细信息
	 */
	@Override
	public ArticalVO queryByPK(Integer pk) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArticalVO vo = null;
		try{
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(ARTICAL_QUERY_BY_ID);
			pstm.setInt(1, pk);
			rs = pstm.executeQuery();
			while(rs.next()){
				vo = new ArticalVO();
				vo.setId(rs.getInt(1));
				vo.setAuthorId(rs.getInt(2));
				vo.setTypeId(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setCreateTime(rs.getTimestamp(6));
				vo.setAuthorName(rs.getString(7));
				vo.setTypeName(rs.getString(8));
			}
		}catch(Exception e){
			log.error("查询文章信息失败!");
		}finally{
			C3P0DBUtil.attemptCloseAll(rs, pstm, con);
		}
		return vo;
	}

}
