package cn.start6.zk.web.sys.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.start6.zk.utils.R;
import cn.start6.zk.web.sys.entity.SysUserEntity;
import cn.start6.zk.web.sys.mapper.SysUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhoukai
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    SysUserMapper sysUserMapper;

    @ApiOperation(value = "用户列表 分页")
    @GetMapping("/listAll")
    public R<PageInfo<Object>> listAll() {
        final PageInfo<Object> info = PageHelper.startPage(1, 10).doSelectPageInfo(() -> sysUserMapper.selectAll());
        return R.ok(info);
    }

    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public List<SysUserEntity> list(@Param("account") final String account) {
        return sysUserMapper.findByUsername(account);
    }

    @PostMapping("/add")
    public int add(@RequestBody @Valid final SysUserEntity sysUserEntity) {
        return sysUserMapper.insert(sysUserEntity);
    }
}
