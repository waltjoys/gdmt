package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.User;
import com.joys.gdmt.Entities.VO.UserCreateVO;
import com.joys.gdmt.Entities.VO.UserVO;
import com.joys.gdmt.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @GetMapping("findAll")
    public List<UserVO> findall() {
        List<UserVO> user = mapper.getuser();
        user.forEach(e -> {
            e.setDutyid(mapper.getdutyid(e.getId()).toString());
        });
        return user;
    }

    @PostMapping("insert")
    public void Insert(@RequestBody UserCreateVO u) {
        User user = new User(u.getOrganid(), u.getName(), u.getPassword(), u.getEmail(), u.getPhone(), u.getDuty());
        mapper.insert(user);
        String s = u.getDuty().replace("[", "").replace("]", "");
        //System.out.println(s);
        if (!s.isEmpty()) {
            String[] dutys = s.split(",");
            for (int i = 0; i < dutys.length; i++) {
                //System.out.println(Integer.parseInt(dutys[i]));
                mapper.userduty(user.getId(), Integer.parseInt(dutys[i]));
            }
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody UserVO u) {
        mapper.deleteById(u.getId());
        mapper.deleteUserDuty(u.getId());
    }

    @PostMapping("update")
    public void update(@RequestBody UserVO u) {
        User user = mapper.selectById(u.getId());
        user.setName(u.getName());
        user.setEmail(u.getEmail());
        user.setOrganid(u.getOrganid());
        user.setPassword(u.getPassword());
        user.setPhone(u.getPhone());
        //System.out.println(user.getPassword());
        mapper.updateById(user);
        mapper.deleteUserDuty(u.getId());
        String s = u.getDutyid().replace("[", "").replace("]", "");
        //System.out.println(s);
        if (!s.isEmpty()) {
            String[] dutys = s.split(",");
            for (int i = 0; i < dutys.length; i++) {
                //System.out.println(Integer.parseInt(dutys[i]));
                mapper.userduty(u.getId(), Integer.parseInt(dutys[i]));
            }
        }
    }
}
