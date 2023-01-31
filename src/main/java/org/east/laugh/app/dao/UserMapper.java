package org.east.laugh.app.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.east.laugh.app.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> SelectAll();

    @Insert("insert into user (id,email, pwd, name, `group`, info) VALUE (null,#{email},#{pwd},#{name},#{group},#{info})")
    void Insert(User user);
}
