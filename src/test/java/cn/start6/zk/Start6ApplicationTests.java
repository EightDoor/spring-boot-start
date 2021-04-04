package cn.start6.zk;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.start6.zk.web.sys.entity.SysUserEntity;
import cn.start6.zk.web.sys.mapper.SysUserMapper;

@SpringBootTest
class Start6ApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(Start6ApplicationTests.class);

    @Autowired
    private SysUserMapper userMapper;

    @Test
    void contextLoads() {}

    @Test
    public void test() {
        final SysUserEntity user = new SysUserEntity();
        user.setAccount("p1").setPassWord("p1");
        final int row = userMapper.insert(user);
        logger.info("[添加结果] - [{}]", row);

        final List<SysUserEntity> row2 = userMapper.findByUsername("p1");
        logger.info("[根据用户查询结果] - [{}]", row2);
    }

}
