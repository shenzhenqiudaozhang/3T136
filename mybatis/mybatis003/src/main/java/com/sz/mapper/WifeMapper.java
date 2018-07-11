package com.sz.mapper;

import com.sz.entity.Wife;
import org.apache.ibatis.annotations.Param;

public interface WifeMapper {


    Wife selectByPrimaryKey(@Param("id") Integer id);
}
