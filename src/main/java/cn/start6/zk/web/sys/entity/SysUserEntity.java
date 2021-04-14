package cn.start6.zk.web.sys.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.start6.zk.common.entity.CommentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "用户管理", description = "用户管理实体")
public class SysUserEntity extends CommentEntity implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;
    /**
     * 登陆账号
     */
    @ApiModelProperty(value = "登陆账号", required = true)
    private String account;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 所属状态是否有效 1是有效 0是失效
     */
    @ApiModelProperty(value = "所属状态是否有效 1是有效 0是失效", example = "1")
    private String status;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phoneNum;
}
