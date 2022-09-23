package cn.lotlyz.cake.mapper;

import cn.lotlyz.cake.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();
    @Insert("insert into user set uName=#{uName},uPassword=#{uPassword}" +
            ",uIdCard=#{uIdCard},uRegistrationTime=#{uRegistrationTime}" +
            ",uAddress=#{uAddress}")
    void insertUser(User user);
}
