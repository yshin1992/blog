package blog.domain;

import java.sql.Timestamp;

/**
 * 文章实体类
 * @author Administrator
 *
 */
public class Artical implements Entity {

	/**
	 * 文章ID
	 */
	private Integer id;
	
	/**
	 * 作者ID
	 */
	private Integer authorId;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 文章内容
	 */
	private String content;
	
	/**
	 * 文章创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 文章类型Id
	 */
	private String typeId;
	
	/**
	 * 文章状态
	 */
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Artical [id=" + id + ", authorId=" + authorId + ", title="
				+ title + ", content=" + content + ", createTime=" + createTime
				+ ", typeId=" + typeId + ", status=" + status + "]";
	}

}
