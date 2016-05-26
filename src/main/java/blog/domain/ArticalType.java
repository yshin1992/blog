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
	private Short id;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 父类型ID
	 */
	private Short parentId;
	
	/**
	 * 有效标记
	 */
	private Boolean status;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Short getParentId() {
		return parentId;
	}

	public void setParentId(Short parentId) {
		this.parentId = parentId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ArticalType [id=" + id + ", typeName=" + typeName
				+ ", parentId=" + parentId + ", status=" + status + "]";
	}
	
}
