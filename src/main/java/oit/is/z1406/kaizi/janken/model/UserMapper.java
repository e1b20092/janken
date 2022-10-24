package oit.is.z1406.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

  @Select("SELECT * from users;")
  ArrayList<User> selectAllUserName();

  @Select("SELECT * from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT * from users where userName = #{userName}")
  User selectByName(String userName);
}
