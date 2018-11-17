/**
 * 
 */
package pers.jssd.blog.bean;

import java.util.Date;

/**
 * @author jssd
 *
 */
public class Blog {
	
	private Integer id;
	private String author;
	private String title;
	private String info;
	private String type;
	private Date createTime;
	private Date updateTime;
	private Integer visitCount;
	private String content;
	
	public Blog () {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "BlogText [getId()=" + getId() + ", getAuthor()=" + getAuthor() + ", getTitle()=" + getTitle()
				+ ", getInfo()=" + getInfo() + ", getCreateTime()=" + getCreateTime() + ", getUpdateTime()="
				+ getUpdateTime() + ", getVisitCount()=" + getVisitCount() + ", getContent()=" + getContent() + "]";
	}
	
	
}
