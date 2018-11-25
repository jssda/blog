/**
 * 
 */
package pers.jssd.blog.test;

import java.sql.SQLIntegrityConstraintViolationException;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.BlogDao;
import pers.jssd.blog.dao.Imp.BlogDaoImp;

/**
 * @author jssd
 *
 */
public class InsertTest {
	
	public static void main(String[] args) {
		User user = new User();
		BlogDao blogDao = new BlogDaoImp();
//		user.setName("jssd");
//		user.setPassword("142536");
//		user.setGender("man");
//		user.setAge(20);
//		user.setTelephone("15188875022");
//		user.setEmail("1624022009@qq.com");
//		user.setIntroduction("本宝宝还没有想好");
		
//		UserDao userDaoImp = new UserDaoImp();
		
		try {
			for(int i = 1; i < 100; i ++) {
				Blog blog = new Blog();
				blog.setTitle("测试标题" + i);
				blog.setAuthor("jssd");
				if(i % 4 == 0) {
					blog.setType("C");
					blog.setInfo("这只是测试" + i + "的测试信息, 类型为c语言");
					blog.setContent("#include <stdio.h>"
							+ "int main() {"
							+ "	printf(\"Hello World!\\n\",);"
							+ "}");
				} else if(i % 4 == 1) {
					blog.setType("c++");
					blog.setInfo("这只是测试" + i + "的测试信息, 类型为c++语言");
					blog.setContent("#include <iostream>"
							+ "int main() {"
							+ "	cout << \"hello world\" << endl;"
							+ "	return 0;"
							+ "}");
				} else if(i % 4 == 2) {
					blog.setType("java");
					blog.setInfo("这只是测试" + i + "的测试信息, 类型为Java语言");
					blog.setContent("public static void main(String args[]) {"
							+ "	System.out.println(\"Hello World\");"
							+ "}");
				} else if(i % 4 == 3) {
					blog.setType("python");
					blog.setInfo("这只是测试" + i + "的测试信息, 类型为python语言");
					blog.setContent("print('hello World')");
				}
				blogDao.addBlog(blog);
			}
//			userDaoImp.addUser(user);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
