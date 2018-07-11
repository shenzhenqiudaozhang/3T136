package com.sz.mapper;

import com.sz.entity.Author;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {



    Author selectByPrimaryKeyWithBlogs(@Param("id")Integer id);


    Author selectByPrimaryKeyWithBlogsAndComments(@Param("id")Integer id);
}
