package com.sz;

import com.sz.mapper.StudentMapper;
import com.sz.entity.Student;
import com.sz.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {


    @Test
    public void m1(){
        // 1 定义mybatis核心配置文件的位置
        String resource = "mybatis.cfg.xml";
        // 2 通过mybatis的工具类加载这个文件为输入流
        InputStream in = null;
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            in = Resources.getResourceAsStream(resource);
            // 3 创建一个会话工厂  会话工厂的建造者（一次性用品）
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 4 利用工厂生产会话
            sqlSession = sessionFactory.openSession();
            // 5 使用会话进行相关的操作

            // 得到一个Mapper，mybatis本身通过动态代理帮我们去创建实例
            // 记住他就行了。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

//            List<Student> students = mapper.listAll();
//            System.out.println(students);
            // 这种写法有弊端，里面的字符串非常容易拼写错误。
//            List<Student> students = sqlSession.selectList("com.sz.dao.StudentDao.listAll");
//            System.out.println(students);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void m2(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.listAll();
        System.out.println(students);
        if(sqlSession != null)
            sqlSession.close();
    }


    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student s = new Student();

        try{
            s.setAge(82);
            s.setName("暗黑");
//        s.setId(4445);
            mapper.insert(s);
            // 加了一行，提交事务。
            sqlSession.commit();
        } catch (SqlSessionException e){
            sqlSession.rollback();
        } finally {
            if(sqlSession != null)
                sqlSession.close();
        }

    }


    // 对于mybatis而言，如果仅仅是单个参数传入，写啥都没问题。
    @Test
    public void selectByName(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.selectByName("王菲");
        // 如果你的目的是查询单个值，而结果却匹配了多个，那么将会抛出异常。
        // 按照主键查询的时候才会定义结果集为单个对象。
        Student student = mapper.selectByName("暗黑");
        System.out.println(student);

    }


    @Test
    public void selectByNameAndAge(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//      mybatis针对多个参数，默认命名机制为arg0 arg1..... param1 param
        Student student = mapper.selectByNameAndAge("王菲", 48);
        System.out.println(student);

    }


    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//
        Student s = new Student();
        s.setId(1);
        s.setName("王靖雯");
        s.setAge(16);
        int row = mapper.update(s);
        System.out.println("影响行数：" + row);
        sqlSession.commit();


    }


    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int row = mapper.deleteByPrimaryKey(1);
        System.out.println(row);
        sqlSession.commit();
    }
}






