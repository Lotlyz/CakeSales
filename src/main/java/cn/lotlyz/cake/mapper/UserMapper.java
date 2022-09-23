package cn.lotlyz.cake.mapper;

import cn.lotlyz.cake.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //查询所有
    @Select("select * from user")
    List<User> findAll();
    //添加用户
    @Insert("insert into user set uName=#{uName},uPassword=#{uPassword}" +
            ",uIdCard=#{uIdCard},uRegistrationTime=#{uRegistrationTime}" +
            ",uAddress=#{uAddress}")
    void insertUser(User user);

    @Delete("delete  from user where uid=#{uid}")
    void deleteByid(int id);
}
