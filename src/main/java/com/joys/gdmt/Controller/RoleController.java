package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.Role;
import com.joys.gdmt.Entities.VO.RoleCreateVO;
import com.joys.gdmt.Entities.VO.RoleUpdateVO;
import com.joys.gdmt.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    RoleMapper mapper;

    @PostMapping("insert")
    void insert(@RequestBody RoleCreateVO r) {
        Role role = new Role(r.getName());
        String s = r.getResid().replace("[", "").replace("]", "");
        mapper.insert(role);
        //System.out.println(s);
        if (!s.isEmpty()) {
            String[] res = s.split(",");
            for (int i = 0; i < res.length; i++) {
                //System.out.println(Integer.parseInt(dutys[i]));
                mapper.RoleRes(role.getId(), Integer.parseInt(res[i]));
            }
        }
    }

    @PostMapping("delete")
    void delete(@RequestBody Role r) {
        mapper.DeleteRoleRes(r.getId());
        mapper.updateRelatedDuty(r.getId());
        mapper.deleteById(r.getId());
    }

    @PostMapping("update")
    void update(@RequestBody RoleUpdateVO r) {
        mapper.DeleteRoleRes(r.getId());
        Role role = mapper.selectById(r.getId());
        role.setName(r.getName());
        mapper.updateById(role);
        String s = r.getResid().replace("[", "").replace("]", "");
        //System.out.println(s);
        if (!s.isEmpty()) {
            String[] res = s.split(",");
            for (int i = 0; i < res.length; i++) {
                //System.out.println(Integer.parseInt(dutys[i]));
                mapper.RoleRes(r.getId(), Integer.parseInt(res[i]));
            }
        }
    }

    @GetMapping("list")
    List<Role> list() {
        List<Role> role = mapper.selectList(null);
        role.forEach(r -> {
            r.setResid(mapper.getresid(r.getId()).toString());
        });
        return role;
    }
}
