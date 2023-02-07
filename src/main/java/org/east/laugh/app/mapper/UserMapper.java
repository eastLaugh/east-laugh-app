package org.east.laugh.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.east.laugh.app.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> SelectAll();

    User SelectById(@Param("id") int value);


    User SelectWithBlogsById(@Param("id") int value);

    List<User> SelectByEmailAndPwd(@Param("email") String email,@Param("pwd") String pwd);


    void Insert(User user);


    User SelectByEmail(@Param("email")String value);


}
