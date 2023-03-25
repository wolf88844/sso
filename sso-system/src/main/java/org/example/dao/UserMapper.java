package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select id,username,password,status from tb_users where username=#{username}")
    User selectUserByUsername(String username);

    @Select("select distinct m.permission from tb_user_roles ur join tb_role_menus rm on ur.role_id=rm.role_id" +
            " join tb_menus m on rm.menu_id=m.id where ur.user_id=#{userId}")
    List<String> selectUserPermissions(Long userId);
}
