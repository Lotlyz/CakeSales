package cn.lotlyz.cake.mapper;

import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    @Select("SELECT password FROM cake.admin where  name = #{name}")
    String selectpassword(String username);
}
