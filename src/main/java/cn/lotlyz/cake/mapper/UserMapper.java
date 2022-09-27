package cn.lotlyz.cake.mapper;

import cn.lotlyz.cake.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //查询所有
    @Select("select * from user")
    List<User> findAll();
    //添加用户
    @Insert("insert into user set userName=#{userName},userPassword=#{userPassword}" +
            ",userIdCard=#{userIdCard},userRegistrationTime=#{userRegistrationTime}" +
            ",userAddress=#{userAddress}")
    void insertUser(User user);

    @Delete("delete  from user where userId=#{userId}")
    void deleteByid(int id);

    @Update("update user set userName=#{userName},userPassword=#{userPassword}" +
            ",userIdCard=#{userIdCard}," +
            "userAddress=#{userAddress} where userId=#{userId}")
    void updateUser(User user);



    @Select("select * from user where userId = #{userId}")
    User findById(int id);


//    void save(List<User> cachedDataList);
}
