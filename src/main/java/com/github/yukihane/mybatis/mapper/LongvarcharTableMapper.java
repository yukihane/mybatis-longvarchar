package com.github.yukihane.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LongvarcharTableMapper {

    @Insert("insert into longvarchar_table(longvarchar_column) values (#{str})")
    int insert(String str);

    @Update("update longvarchar_table set longvarchar_column=#{str}")
    int update(String str);

    @Select("select longvarchar_column from longvarchar_table")
    List<String> select();
}
