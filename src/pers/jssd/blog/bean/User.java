/**
 * 
 */
package pers.jssd.blog.bean;

import java.util.*;

/**
 * @author jssd
 *
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String gender;
	private Integer age;
	private String telephone;
	private String email;
	private String introduction;
	private Date createtime;
	private Date updatetime;
	
	public User() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	@Override
	public String toString() {
		return "User [getId()=" + getId() + ", getName()=" + getName() + ", getPassword()=" + getPassword()
				+ ", getGender()=" + getGender() + ", getAge()=" + getAge() + ", getTelephone()=" + getTelephone()
				+ ", getEmail()=" + getEmail() + ", getIntroduction()=" + getIntroduction() + ", getCreatetime()="
				+ getCreatetime() + ", getUpdatetime()=" + getUpdatetime() + "]";
	}
	
	
}
