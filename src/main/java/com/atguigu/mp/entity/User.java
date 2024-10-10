package com.atguigu.mp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
// 数据库表名和实体类明不相同使用,如果数据库的表名是sys_user,而实体的名称为User,就可以使用这个注解
//@TableName("sys_user")
public class User {
//  数据表字段默认新增Id的算法,原理使用的是雪花算法来实现,唯一有序Id值
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
// 注解表示数据库表字段和实体字段不同是使用k
//    @TableField("nick_name")
    private String name;
    private Integer age;
    private String email;
    // 逻辑删除字段
    // mybatis-plus下,默认 逻辑删除值为1 未逻辑删除 0
    @TableLogic
    private Integer deleted;
    // 添加一个数据库表不存在的字段,多数情况下是用来做冗余使用
    @TableField(exist = false)
    private String remark;

}
