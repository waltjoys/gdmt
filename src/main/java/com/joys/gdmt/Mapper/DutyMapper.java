package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.Duty;
import com.joys.gdmt.Entities.VO.DutyVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DutyMapper extends BaseMapper<Duty> {
    @Select("SELECT d.id,d.name,d.organid,o.name AS organname, d.roleid,r.name AS rolename FROM duty d LEFT JOIN organ o ON d.organid=o.id LEFT JOIN role r ON d.roleid=r.id")
    List<DutyVO> dutylist();

    @Select("DELETE FROM userduty WHERE dutyid = #{id}")
    void deleteUserDuty(Integer id);
}
