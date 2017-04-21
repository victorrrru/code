package cn.interheart.api.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：user
 * @since 2017-04-21 15:18:18
 */
@Alias("User")
public class User implements Serializable {
	/** id -- 主键id */
	private Integer id;

	/** username -- 用户姓名 */
	@NotEmpty(message="test.User.username.NotEmpty")
	@Length(max=50,message="test.User.username.Length")
	private String username;

	/** password -- 用户密码 */
	@NotEmpty(message="test.User.password.NotEmpty")
	@Length(max=50,message="test.User.password.Length")
	private String password;

	/** gendar -- 性别 */
	@Length(max=50,message="test.User.gendar.Length")
	private String gendar;

	/** telephone -- 电话号码 */
	@Length(max=50,message="test.User.telephone.Length")
	private String telephone;

	/** birthday -- 生日 */
	private Date birthday;

	/** remark -- 备注 */
	@Length(max=50,message="test.User.remark.Length")
	private String remark;

	/** createdon -- 创建时间 */
	@NotNull(message="test.User.createdon.NotNull")
	private Date createdon;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getId() {
		return id;
	}

	/** 设置主键id */
	public void setId(Integer id) {
		this.id = id;
	}

	/** 获取用户姓名 */
	public String getUsername() {
		return username;
	}

	/** 设置用户姓名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取用户密码 */
	public String getPassword() {
		return password;
	}

	/** 设置用户密码 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/** 获取性别 */
	public String getGendar() {
		return gendar;
	}

	/** 设置性别 */
	public void setGendar(String gendar) {
		this.gendar = gendar == null ? null : gendar.trim();
	}

	/** 获取电话号码 */
	public String getTelephone() {
		return telephone;
	}

	/** 设置电话号码 */
	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/** 获取生日 */
	public Date getBirthday() {
		return birthday;
	}

	/** 设置生日 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取修改时间 */
	public Date getModifiedon() {
		return modifiedon;
	}

	/** 设置修改时间 */
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	/**
	
	 * @since 2017-04-21 15:18:18
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
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-04-21 15:18:18
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
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}