package com.yee.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: MyMateObject
 * Description:
 * date: 2021/12/18 16:44
 *  自动填充,比如插入和更新的时候自动创建时间
 *  this.setFieldValByName第一个参数表示字段名,第二个参数是值,第三个参数元数据
 * @author Yee
 * @since JDK 1.8
 */
@Component
public class MyMateObject implements MetaObjectHandler {

    @Override    //插入填充
    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //默认插入版本为1
        this.setFieldValByName("version",1,metaObject);
       //默认不删除
        this.setFieldValByName("deleted",0,metaObject);
    }

    @Override   //更新填充
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
