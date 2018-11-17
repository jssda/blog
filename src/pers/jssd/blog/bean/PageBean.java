/**
 * 
 */
package pers.jssd.blog.bean;

import java.util.List;

/**
 * @author jssd
 *
 */
public class PageBean <T>{

	private int count = 0;
	private int currpage = 0;
	private int pageSize = 0;
	private List<T> list = null;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
