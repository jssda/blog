/**
 * 数据库连接工具
 */

package pers.jssd.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;;

/**
 * @author jssd
 *
 */

public class DBUtil {
	
	//=======数据库连接信息========   
	static String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=UTC";
    static String username = "jssd";
    static String password = "jssd";
    static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	
	public DBUtil() {	}
	
    /**
     * 获取数据库连接
     * @author jssd
     */
    public static Connection getConnection(){
        
        Connection connection = null;
        
        try {
            //加载驱动
            Class.forName(driverClassName);
            
            //获取连接
            connection = DriverManager.getConnection(url,username,password);
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return connection;
    }
    
    /**
     * 释放连接
     * @author jssd
     * 
     * */
    public static void closeConnection(Connection connection,PreparedStatement st,ResultSet rs){
        try {
            if(connection!= null){
                connection.close();
            }
            if(st!= null){
                st.close();
            }
            if(rs!= null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
