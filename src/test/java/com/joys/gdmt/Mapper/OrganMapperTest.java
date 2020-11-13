package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joys.gdmt.Entities.Organ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrganMapperTest {
    @Autowired
    OrganMapper mapper;
    @Test
    void updaterelated(){
        mapper.updateRelatedUser(4);
        mapper.updateRelatedDuty(4);
    }
//    获取组织结构树
    @Test
    void gettree(){
        Organ root=findroot();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("pid",root.getId());
        List<Organ> list=mapper.selectList(wrapper);
        getchildren(list);
        root.setChildren(list);
        System.out.println(root);
    }
//    获取组织结构树根节点
    @Test
    Organ findroot(){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("pid",0);
        return (Organ) mapper.selectList(wrapper).get(0);
    }
//    递归寻找树的子节点
    @Test
    void getchildren(List<Organ> list){
        list.forEach(organ -> {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("pid", organ.getId());
            organ.setChildren(mapper.selectList(wrapper));
            getchildren(organ.getChildren());
        });
    }
}