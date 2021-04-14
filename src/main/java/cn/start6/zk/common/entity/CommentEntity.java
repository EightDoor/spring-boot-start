package cn.start6.zk.common.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhoukai
 */
public class CommentEntity {
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private int createdAt;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private int updatedAt;
    /**
     * 删除时间
     */
    @ApiModelProperty(value = "删除时间")
    private int deletedAt;
}
