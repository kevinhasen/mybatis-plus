package com.yee;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yee.mapper.UserMapper;
import com.yee.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

/**
 * ClassName: UserTest
 * Description:
 * date: 2021/12/18 15:57
 *
 * @author Yee
 * @since JDK 1.8
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserById(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void updateUser(){
        User user = userMapper.selectById(1472219183575007234L);
        user.setName("王五");
        userMapper.updateById(user);
    }
    @Test
    public void addUser(){
        User user = new User();
        user.setName("李四");
        user.setAge(35);
        userMapper.insert(user);
    }

    //分页查询
    @Test
    public void pageUser(){
        //参数,当前页和展示数量
        Page<User> pages = new Page<>(1,2);
        userMapper.selectPage(pages,null);
        System.out.println("pages.getTotal() = " + pages.getTotal());
        System.out.println("pages.getPages() = " + pages.getPages());
    }

    @Test
    public void deleteUser(){
        userMapper.deleteById(1472219183575007234L);
    }

    //根据条件查询
    @Test
    public void selectAge(){
        //使用子类查询
        QueryWrapper wrapper =  new QueryWrapper();
        //查询名字为jone的用户
//        wrapper.eq("name","Jone");
        //年龄大于23的人
//        wrapper.ge("age",23);
        //范围取值,前包后包
//        wrapper.between("age",24,44);
        //模糊匹配
//        wrapper.like("name","张");
        //根据年龄排序,或者逗号隔开多个字段
        wrapper.orderByDesc("age");
        //只显示某些字段
        wrapper.select("age","name");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
}
