package com.joys.gdmt.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joys.gdmt.Entities.Organ;
import com.joys.gdmt.Entities.VO.OrganCreateVO;
import com.joys.gdmt.Entities.VO.OrganUpdateVO;
import com.joys.gdmt.Entities.VO.OrganVO;
import com.joys.gdmt.Mapper.OrganMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//注释控制器
@RestController
//请求路径
@RequestMapping("/Organ")
public class OrganController {
    //自动装载IOC
    @Autowired
    private OrganMapper mapper;
    //获取组织结构树
    @GetMapping("/Tree")
    List<Organ> getTree(){
        List<Organ> Tree=findroot();//寻找组织结构树根节点
//        QueryWrapper wrapper=new QueryWrapper();
//        wrapper.eq("pid",Tree.get(0).getId());
//        List<Organ> list=mapper.selectList(wrapper);//查询所有父节点是根节点的节点
//        getchildren(list);                          //调用递归函数递归查询子节点
//        Tree.get(0).setChildren(list);
        getchildren(Tree);
        return Tree;
    }
//寻找根节点
    List<Organ> findroot(){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("pid",0);                    //查询父节点为0的数据
        return  mapper.selectList(wrapper);
    }
//    获取孩子节点
    void getchildren(List<Organ> list){
        list.forEach(organ -> {                             //遍历所有节点
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("pid", organ.getId());       //查询所有父节点id和当前id相等的数据
            organ.setChildren(mapper.selectList(wrapper));  //查询节点的子节点并赋值给该节点
            getchildren(organ.getChildren());               //循环调用
        });
    }
    //添加组织
    @PostMapping("/Insert")
    void insert(@RequestBody OrganCreateVO organVO){
        Organ o = new Organ(organVO.getName(),organVO.getPid());
        mapper.insert(o);
    }
    //获取组织列表
    @GetMapping("/All")
    List<OrganVO> OrganList(){
        return mapper.OrganList();
    }
    //修改组织信息
    @PostMapping("/update")
    void update(@RequestBody OrganUpdateVO o){
        if(o.getPid()==null){
            o.setPid(0);
        }
        Organ organ = mapper.selectById(o.getId());
        organ.setName(o.getName());
        organ.setPid(o.getPid());
        mapper.updateById(organ);
    }
    //删除组织信息
    @PostMapping("/delete")
    void delete(@RequestBody OrganVO o){
        mapper.updateChildren(o.getId());
        mapper.updateRelatedUser(o.getId());
        mapper.updateRelatedDuty(o.getId());
        mapper.deleteById(o.getId());
    }
}
