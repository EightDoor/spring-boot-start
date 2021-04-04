package cn.start6.zk.web.sys.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.start6.zk.web.sys.entity.SysUserEntity;
import cn.start6.zk.web.sys.mapper.SysUserMapper;

/**
 * @author zhoukai
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    SysUserMapper sysUserMapper;

    @GetMapping("listAll")
    public PageInfo<Object> listAll() {
        return PageHelper.startPage(1, 10).doSelectPageInfo(() -> sysUserMapper.selectAll());
    }

    @GetMapping("/list")
    public List<SysUserEntity> list(@Param("account") final String account) {
        return sysUserMapper.findByUsername(account);
    }

    @PostMapping("/add")
    public int add(@RequestBody final SysUserEntity sysUserEntity) {
        return sysUserMapper.insert(sysUserEntity);
    }
}
