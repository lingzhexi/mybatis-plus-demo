package com.atguigu.mp.entity;


import lombok.Data;

@Data
//@TableName("sys_user")
public class User {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
//    @TableField("nick_name")
    private String name;
    private Integer age;
    private String email;
//    @TableLogic
//    //逻辑删除字段 int mybatis-plus下,默认 逻辑删除值为1 未逻辑删除 0
//    private Integer deleted;
//    @TableField(exist = false)
//    private String remark;

}
