package com.sz;

import com.sz.entity.User;
import com.sz.mapper.UserMapper;
import com.sz.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {


    @Test
    public void m1() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
        u.setId(3);
        u.setName("东方不败");
        mapper.inserTive(u);
        session.commit();
        session.close();


    }




    @Test
    public void m2() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
        u.setId(2);
//        u.setAge(22);
        List<User> users = mapper.selecTive(u);
        System.out.println(users);
    }


    @Test
    public void m3() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
//        User u = new User();
        List<User> users = mapper.selectByGender(0);
        System.out.println(users);
    }



    @Test
    public void m4() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
//        u.setId(1);
        u.setName("徐峥");
        u.setAge(45);
        if(u.getId() == null)
            return;
        mapper.update(u);
        session.commit();
    }


    @Test
    public void m5() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
//      u
        u.setId(3);
        u.setName("东方朔");
        u.setGender(1);
        u.setAge(1850);
        mapper.update2(u);
        session.commit();
    }


    @Test
    public void m6() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.listAll();
        System.out.println(users);
    }


    @Test
    public void m7() {
        SqlSession session = MybatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        if(ids.size() <= 0)
            return;
        List<User> users = mapper.findInIds(ids);
        System.out.println(users);
    }
}















