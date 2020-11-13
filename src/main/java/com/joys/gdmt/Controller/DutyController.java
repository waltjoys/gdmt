package com.joys.gdmt.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joys.gdmt.Entities.Duty;
import com.joys.gdmt.Entities.VO.DutyCreateVO;
import com.joys.gdmt.Entities.VO.DutyVO;
import com.joys.gdmt.Entities.VO.OrganVO;
import com.joys.gdmt.Mapper.DutyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Duty")
public class DutyController {
    @Autowired
    DutyMapper mapper;

    @PostMapping("/insert")
    void insert(@RequestBody DutyCreateVO d) {
        Duty duty = new Duty(d.getName(), d.getOrganid(), d.getRoleid());
        //System.out.println(duty);
        mapper.insert(duty);
    }

    @PostMapping("/delete")
    void delete(@RequestBody DutyVO d) {
        mapper.deleteUserDuty(d.getId());
        mapper.deleteById(d.getId());
    }

    @PostMapping("/update")
    void update(@RequestBody Duty duty) {
        mapper.updateById(duty);
    }

    @GetMapping("/list")
    List<DutyVO> List() {
        return mapper.dutylist();
    }

    @PostMapping("/getbyorgan")
    List<Duty> Getlist(@RequestBody OrganVO o) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("organid", o.getId());
        System.out.println(o.getId());
        return mapper.selectList(wrapper);
    }
}
