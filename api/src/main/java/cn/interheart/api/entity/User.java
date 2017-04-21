package cn.interheart.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：user
 * @since 2017-04-18 17:05:48
 */
@Alias("User")
public class User implements Serializable {
	/** id --  */
	private Integer id;

	/** username --  */
	@NotEmpty(message="test.User.username.NotEmpty")
	@Length(max=50,message="test.User.username.Length")
	private String username;

	/** password --  */
	@NotEmpty(message="test.User.password.NotEmpty")
	@Length(max=50,message="test.User.password.Length")
	private String password;

	/** gendar --  */
	@NotEmpty(message="test.User.gendar.NotEmpty")
	@Length(max=50,message="test.User.gendar.Length")
	private String gendar;

	/** telephone --  */
	@NotEmpty(message="test.User.telephone.NotEmpty")
	@Length(max=50,message="test.User.telephone.Length")
	private String telephone;

	/** birthday --  */
	@NotNull(message="test.User.birthday.NotNull")
	private Date birthday;

	/** remark --  */
	@Length(max=50,message="test.User.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getId() {
		return id;
	}

	/** 设置 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** 获取 */
	public String getUsername() {
		return username;
	}

	/** 设置 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取 */
	public String getPassword() {
		return password;
	}

	/** 设置 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/** 获取 */
	public String getGendar() {
		return gendar;
	}

	/** 设置 */
	public void setGendar(String gendar) {
		this.gendar = gendar == null ? null : gendar.trim();
	}

	/** 获取 */
	public String getTelephone() {
		return telephone;
	}

	/** 设置 */
	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/** 获取 */
	public Date getBirthday() {
		return birthday;
	}

	/** 设置 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/** 获取 */
	public String getRemark() {
		return remark;
	}

	/** 设置 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	
	 * @since 2017-04-18 17:05:48
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
			&& (this.getGendar() == null ? other.getGendar() == null : this.getGendar().equals(other.getGendar()))
			&& (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
			&& (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-04-18 17:05:48
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result + ((getGendar() == null) ? 0 : getGendar().hashCode());
		result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
		result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}