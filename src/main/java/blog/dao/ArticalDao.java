package blog.dao;

import java.util.List;

import blog.domain.Artical;
import blog.vo.ArticalVO;

public interface ArticalDao extends Dao<Artical> {
	
	List<ArticalVO> queryByPage();
	
	ArticalVO queryByPK(Integer pk);
}
