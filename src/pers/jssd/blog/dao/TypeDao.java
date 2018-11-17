/**
 * 
 */
package pers.jssd.blog.dao;

import java.util.List;

import pers.jssd.blog.bean.Type;

/**
 * @author jssd
 *
 */
public interface TypeDao {

	/**
	 * @param type
	 * @return boolean
	 */
	public boolean addType(Type type);
	
	/**
	 * @param type
	 * @return List<Type>
	 */
	public List<Type> queryTypeList(Type type);
	
}
