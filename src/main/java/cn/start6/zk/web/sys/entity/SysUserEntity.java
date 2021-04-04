package cn.start6.zk.web.sys.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.start6.zk.common.entity.CommentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户管理
 * 
 * @author zhoukai
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "sys_user")
public class SysUserEntity extends CommentEntity implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 登陆账号
     */
    private String account;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 所属状态是否有效 1是有效 0是失效
     */
    private String status;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机号码
     */
    private String phoneNum;
}
