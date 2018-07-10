package com.sz.mapper;

import com.sz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    /**
     * 动态SQL插入
     * @param u
     * @return
     */
    int inserTive(User u);

    List<User> selecTive(User user);


    List<User> selectByGender(@Param("gender") Integer gender);

    // alt + enter (idea 这是个万能快捷键)
    int update(User user);

    int update2(User user);

    List<User> listAll();

    List<User> findInIds(List<Integer> ids);

}
