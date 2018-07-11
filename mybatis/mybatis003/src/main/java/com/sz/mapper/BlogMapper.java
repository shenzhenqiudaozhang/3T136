package com.sz.mapper;

import com.sz.entity.Blog;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {


    Blog selectByPrimaryKeyWithAuthor(@Param("id") Integer id);


}
