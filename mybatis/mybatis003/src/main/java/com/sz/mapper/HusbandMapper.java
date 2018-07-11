package com.sz.mapper;

import com.sz.entity.Husband;
import org.apache.ibatis.annotations.Param;

public interface HusbandMapper {


    Husband selectByPrimaryKey(@Param("id") Integer id);


    Husband selectByPrimaryKey2(@Param("id") Integer id);


    Husband selectByPrimaryKey3(@Param("id") Integer id);

    int update(Husband husband);
}







