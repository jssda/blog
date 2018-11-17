/**
 * 
 */
package pers.jssd.blog.service.imp;

import java.util.List;

import pers.jssd.blog.bean.Type;
import pers.jssd.blog.dao.TypeDao;
import pers.jssd.blog.dao.Imp.TypeDaoImp;
import pers.jssd.blog.service.TypeService;

/**
 * @author jssd
 *
 */
public class TypeServiceImp implements TypeService {

	TypeDao typeDao = new TypeDaoImp();
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.TypeService#queryTypeList(pers.jssd.blog.bean.Type)
	 */
	@Override
	public List<Type> queryTypeList(Type type) {
		// TODO Auto-generated method stub
		return typeDao.queryTypeList(type);
	}

}
