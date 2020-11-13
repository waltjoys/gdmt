package com.joys.gdmt.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joys.gdmt.Entities.Res;
import com.joys.gdmt.Entities.VO.ResCreateVO;
import com.joys.gdmt.Entities.VO.ResUpdateVO;
import com.joys.gdmt.Entities.VO.ResVO;
import com.joys.gdmt.Mapper.ResMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Res")
public class ResController {
    @Autowired
    private ResMapper mapper;

    @PostMapping("insert")
    void insert(@RequestBody ResCreateVO r) {
        Res res = new Res(r.getName(), r.getPid());
        mapper.insert(res);
    }

    @PostMapping("delete")
    void delete(@RequestBody ResVO r) {
        mapper.updateChildren(r.getId());
        mapper.deleteRoleRes(r.getId());
        mapper.deleteById(r.getId());
    }

    @PostMapping("update")
    void update(@RequestBody ResUpdateVO r) {
        Res res = mapper.selectById(r.getId());
        res.setName(r.getName());
        if (r.getPid() == null) {
            r.setPid(0);
        }
        res.setPid(r.getPid());
        //System.out.println(res.getPid());
        mapper.updateById(res);
    }

    @GetMapping("list")
    List<ResVO> List() {
        return mapper.reslist();
    }

    @GetMapping("/tree")
    List<Res> Tree() {
        List<Res> list = findroot();
        getchildren(list);
        return list;
    }

    List<Res> findroot() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid", 0);                    //查询父节点为0的数据
        return mapper.selectList(wrapper);
    }

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
