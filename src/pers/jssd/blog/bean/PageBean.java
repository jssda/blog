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

	int count = 0;
	int currpage = 0;
	int pageSize = 0;
	List<T> list = null;
	
}
