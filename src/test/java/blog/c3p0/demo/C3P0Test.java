package blog.c3p0.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.TestCase;

public class C3P0Test extends TestCase {

	/*public void testConnTime()
	{
		Date begin = new Date();
		for(int i=0;i<50;i++)
		{
			try {
				Date before = new Date();
				Connection con = C3P0DBUtil.getConnection();
				Date after = new Date();
				System.out.println("获取连接:"+(after.getTime()-before.getTime()));
				C3P0DBUtil.attemptClose(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Date end = new Date();
		System.out.println("获取十次连接总耗时:"+(end.getTime()-begin.getTime()));
	}*/
	
	public void testConnTimeWithoutPool()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String url = "jdbc:mysql://10.61.61.29:13306/emcs_sunwinbus";
		String user = "emcs_sunwinbus";
		String pswd = "emcs_sunwinbus";
		Date begin = new Date();
		try {
			for(int i = 0;i< 50;i++){
				Date before = new Date();
				Connection con = DriverManager.getConnection(url, user, pswd);
				Date after = new Date();
				System.out.println("获取连接:"+(after.getTime()-before.getTime()));
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println("获取十次连接总耗时:"+(end.getTime()-begin.getTime()));
	}
}
