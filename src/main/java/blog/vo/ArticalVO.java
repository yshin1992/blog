package blog.vo;

import blog.domain.Artical;

public class ArticalVO extends Artical {
	
	/**
	 * 文章类型名称
	 */
	private String typeName;
	
	/**
	 * 文章作者名称
	 */
	private String authorName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
