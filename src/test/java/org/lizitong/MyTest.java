package org.lizitong;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lizitong.dao.studentDao;
import org.lizitong.domain.student;
import org.lizitong.utils.mybatisUtil;

import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        student stu = new student();
        stu.setAge(99);
        stu.setEmail("777.com");
        stu.setId(1006);
        stu.setName("小鲁班");

        //获取SqlSession
        SqlSession session = mybatisUtil.getSqlSession();
        //获取dao的代理,创建了studentDao接口的对象
        studentDao dao = session.getMapper(studentDao.class);
        student student = dao.selectById(1006);
        List<student> students = dao.selectByNameOrEmail("小刘","777.com");
        List<student> students1 = dao.selectByObject(stu);
        List<student> students2 = dao.selectByPosition("小鲁班","654.com");

        System.out.println("查询的结果=" + student);
        System.out.println("hot-fix的git测试");
        //关闭SqlSession对象
        session.close();
    }
}
