package blog.domain;

/**
 * 文章类型实体类
 * @author Administrator
 *
 */
public class ArticalType implements Entity {
	
	/**
	 * 文章类型ID
	 */
	private String id;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 父类型ID
	 */
	private String parentId;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "ArticalType [id=" + id + ", typeName=" + typeName
				+ ", parentId=" + parentId + "]";
	}
	
}
