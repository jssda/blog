/**
 * 
 */
package pers.jssd.blog.service;

import java.util.List;

import pers.jssd.blog.bean.Type;

/**
 * @author jssd
 *
 */
public interface TypeService {
	/**
	 * @param type
	 * @return List<Type>
	 */
	public List<Type> queryTypeList(Type type);

	/**
	 * @param type
	 * @return boolean
	 */
	public boolean addType(Type type);
}
