package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joys.gdmt.Entities.Res;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ResMapperTest {
    @Autowired
    ResMapper mapper;

    @Test
    List<Res> Tree() {
        List<Res> list = findroot();
        getchildren(list);
        return list;
    }

    @Test
    List<Res> findroot() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid", 0);                    //查询父节点为0的数据
        List<Res> list = mapper.selectList(wrapper);
        System.out.println(list);
        return list;
    }

    @Test
        //    获取孩子节点
    void getchildren(List<Res> list) {
        list.forEach(res -> {                             //遍历所有节点
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("pid", res.getId());       //查询所有父节点id和当前id相等的数据
            res.setChildren(mapper.selectList(wrapper));  //查询节点的子节点并赋值给该节点
            getchildren(res.getChildren());               //循环调用
        });
    }

}