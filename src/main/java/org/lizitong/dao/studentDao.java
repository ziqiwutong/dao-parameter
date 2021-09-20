package org.lizitong.dao;

import org.apache.ibatis.annotations.Param;
import org.lizitong.domain.student;

import java.util.List;

public interface studentDao {
    student selectById(Integer id);

    //若接口方法的形参为多个简单类型的参数，应使用@Param在形参之前命名参数，@Param中的值与形参名称对应
    List<student> selectByNameOrEmail(@Param("myname") String name,@Param("myemail") String email);
    //使用java对象作为参数（对象应当有属性且每个属性都有set，get方法）,这里只要是一个符合要求的对象就可以
    List<student> selectByObject(student student);
    //利用参数位置进行传参
    List<student> selectByPosition(String name,String email);
}
