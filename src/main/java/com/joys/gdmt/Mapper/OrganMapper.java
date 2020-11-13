package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.Organ;
import com.joys.gdmt.Entities.VO.OrganVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrganMapper extends BaseMapper<Organ> {
    @Select("SELECT organ.id,organ.name,o.id AS pid,o.name AS pname,organ.createtime FROM organ organ LEFT JOIN organ o ON organ.pid=o.id")
    List<OrganVO> OrganList();
    @Select("UPDATE user SET user.organid = NULL WHERE user.organid = #{id}")
    void updateRelatedUser(Integer id);
    @Select("UPDATE duty SET duty.organid = NULL WHERE duty.organid = #{id}")
    void updateRelatedDuty(Integer id);
    @Select("UPDATE organ SET organ.pid = 0 WHERE organ.pid = #{id}")
    void updateChildren(Integer id);
}
