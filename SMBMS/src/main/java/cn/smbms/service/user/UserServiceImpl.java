package cn.smbms.service.user;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;
import cn.smbms.tools.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	
	private UserMapper userDao;
	private SqlSession session = MybatisUtil.getSession();
	public UserServiceImpl(){
		userDao = session.getMapper(UserMapper.class);
	}
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
//
//		boolean flag = false;
//		Connection connection = null;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);//开启JDBC事务管理
//			int updateRows = userDao.add(connection,user);
//			connection.commit();
//			if(updateRows > 0){
//				flag = true;
//				System.out.println("add success!");
//			}else{
//				System.out.println("add failed!");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				System.out.println("rollback==================");
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}finally{
//			//在service层进行connection连接的关闭
//			BaseDao.closeResource(connection, null, null);
//		}
//		return flag;

		try {
			System.out.println("0000000000000000");
			session = MybatisUtil.getSession();
			userDao = session.getMapper(UserMapper.class);
			int row = userDao.add(user);
//			if(session.)
			System.out.println("111111111");
			session.commit();
			if(row == 1)
				return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			session.rollback();
			return false;
		} finally {
			System.out.println("333333333333");
			if(session != null){
				session.close();
			}
		}
		return false;

	}
	@Override
	public User login(String userCode, String userPassword) {
		User user = userDao.queryUserByUserNameAndPassword(userCode,userPassword);
		if(session != null)
			session.close();
		return user;
	}
	@Override
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<User> userList = null;
		System.out.println("queryUserName ---- > " + queryUserName);
		System.out.println("queryUserRole ---- > " + queryUserRole);
		System.out.println("currentPageNo ---- > " + currentPageNo);
		System.out.println("pageSize ---- > " + pageSize);
//		try {
//			connection = BaseDao.getConnection();
//			userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		System.out.println((currentPageNo-1)*Constants.pageSize + "===" + pageSize);
		userList = userDao.getUserList( queryUserName,queryUserRole,(currentPageNo-1)*Constants.pageSize,pageSize);
		System.out.println(userList.get(0).getUserName()+"=====================================");
		if(session != null)
		    session.close();
		return userList;
	}
	@Override
	public User selectUserCodeExist(String userCode) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		User user = null;
//		try {
//			connection = BaseDao.getConnection();
//			user = userDao.getLoginUser(connection, userCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		return null;
	}
	@Override
	public boolean deleteUserById(Integer delId) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(userDao.deleteUserById(connection,delId) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		int row = userDao.deleteUserById(delId);
		session.commit();
		if(session != null){
		    session.close();
        }
		if(row == 1)
		    return true;
		return false;
	}
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
//		User user = null;
//		Connection connection = null;
//		try{
//			connection = BaseDao.getConnection();
//			user = userDao.getUserById(connection,id);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			user = null;
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		User user = userDao.getUserById(id);
		if(session != null){
			session.close();
		}

		return user;
	}
	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(userDao.modify(connection,user) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return flag;



		try {
			int row = userDao.modify(user);
			session.commit();
			if(row == 1)
				return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			session.rollback();
			return false;
		} finally {

			if(session != null){
				session.close();
			}
		}
		return false;
	}
	@Override
	public boolean updatePwd(int id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection connection = null;
		try{
			connection = BaseDao.getConnection();
			if(userDao.updatePwd(connection,id,pwd) > 0)
				flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}
	@Override
	public int getUserCount(String queryUserName, int queryUserRole) {
		// TODO Auto-generated method stub
		Connection connection = null;
		int count = 0;
		System.out.println("queryUserName ---- > " + queryUserName);
		System.out.println("queryUserRole ---- > " + queryUserRole);
		try {
			connection = BaseDao.getConnection();
			count = userDao.getUserCount( queryUserName,queryUserRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return count;
	}
	
}
