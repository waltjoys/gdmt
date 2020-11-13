package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.Res;
import com.joys.gdmt.Entities.VO.ResVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResMapper extends BaseMapper<Res> {
    @Select("SELECT res.id,res.name,r.id AS pid,r.name AS pname,res.createtime FROM res res LEFT JOIN res r ON res.pid=r.id")
    List<ResVO> reslist();

    @Select("UPDATE res SET res.pid = 0 WHERE res.pid = #{id}")
    void updateChildren(Integer id);

    @Select("DELETE FROM roleres WHERE resid = #{id}")
    void deleteRoleRes(Integer id);
}
