package cn.start6.zk.web.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.start6.zk.web.sys.entity.SysUserEntity;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author zhoukai
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    @Select("SELECT * FROM `sys_user` where account = #{username}")
    /**
     * 根据用户名查询用户列表
     * 
     * @param username
     *            用户名
     * @return sys_user
     */
    List<SysUserEntity> findByUsername(@Param("username") String username);
}
