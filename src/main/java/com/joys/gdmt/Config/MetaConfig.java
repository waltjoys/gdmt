package com.joys.gdmt.Config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createtime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
