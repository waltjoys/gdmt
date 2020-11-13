package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("INSERT INTO roleres (roleid,resid) VALUES (#{roleid},#{resid})")
    void RoleRes(Integer roleid, Integer resid);

    @Select("DELETE FROM roleres WHERE roleid = #{id}")
    void DeleteRoleRes(Integer id);

    @Select("SELECT resid FROM roleres WHERE roleid=#{id}")
    List<Integer> getresid(Integer id);

    @Select("UPDATE duty SET duty.roleid = NULL WHERE duty.roleid = #{id}")
    void updateRelatedDuty(Integer id);
}
