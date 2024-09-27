package com.atguigu.mp;

import com.atguigu.mp.entity.User;
import com.atguigu.mp.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询操作
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //保存操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("Stormling");
        user.setAge(28);
        user.setEmail("501344802@qq.com");
        int rows = userMapper.insert(user);
        System.out.println(user);//id自动回填
        System.out.println(rows);//影响的行数
    }

    //查询操作
    @Test
    public void getUserById() {
        System.out.println(userMapper.selectById(1L));
    }

    //更新操作
    @Test
    public void updateUser() {
        User user = userMapper.selectById(1L);
        user.setName("岳不群");
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    // 删除操作
    @Test
    public void deletedUser() {
        userMapper.deleteById(1L);
    }

    // 条件查询
    @Test
    public void select() {
        //封装条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "Tom")
                .eq(User::getAge, "28");
        //调用方法
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectA() {
        //封装条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getAge, "28");
        //调用方法
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectB() {
        //封装条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "不");
        //调用方法
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    //测试分页
    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent()); // 当前页
        System.out.println(page.getPages());   // 查询列表分页数
        System.out.println(page.getSize());    // 每页显示条数
        System.out.println(page.getTotal());   // 查询列表总记录数
        System.out.println(page.hasNext());	   // 是否有下一页
        System.out.println(page.hasPrevious());// 是否有上一页
    }



}
