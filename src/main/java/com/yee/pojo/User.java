package com.yee.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: User
 * Description:
 * date: 2021/12/18 15:54
 * 自动填充类型必须是date类型
 * 数据库对应的是datetime类型
 * @author Yee
 * @since JDK 1.8
 */
@Data
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)  //自动填充,创建时
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//创建和更新时
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)  //创建时插入版本号
    private Integer version;   //添加乐观锁
    @TableLogic   //0表示未删除,1表示删除
    private Integer deleted;  //逻辑删除
}
