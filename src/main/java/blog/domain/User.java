package blog.domain;

import java.util.Date;

/**
 * User实体
 * @author Administrator
 *
 */
public class User implements Entity {
	
	/**
	 * 用户ID
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String loginName;
	
	/**
	 * 密码
	 */
	private String passwd;
	
	/**
	 * 角色ID
	 */
	private Short roleId;
	
	/**
	 * 用户创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户有效位标记
	 * true 有效 false 无效
	 */
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", passwd="
				+ passwd + ", roleId=" + roleId + ", createTime=" + createTime
				+ ", status=" + status + "]";
	}
	
}
