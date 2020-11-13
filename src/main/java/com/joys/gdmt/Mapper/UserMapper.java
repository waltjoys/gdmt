package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.User;
import com.joys.gdmt.Entities.VO.UserVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("INSERT INTO userduty (userid,dutyid) VALUES (#{userid},#{dutyid})")
    void userduty(Integer userid, Integer dutyid);

    @Select("SELECT u.id,o.id AS organid, o.name AS organname, u.name,u.password, u.email,u.phone FROM user u LEFT JOIN organ o ON u.organid=o.id")
    List<UserVO> getuser();

    @Select("DELETE FROM userduty WHERE userid = #{id}")
    void deleteUserDuty(Integer id);

    @Select("SELECT dutyid FROM userduty WHERE userid=#{id}")
    List<Integer> getdutyid(Integer id);
}
