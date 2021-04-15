package cn.start6.zk.utils;

import java.io.Serializable;

import cn.start6.zk.common.entity.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhoukai
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "是否成功")
    private Boolean state = true;
    @ApiModelProperty(value = "返回数据")
    private T data;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回码")
    private long code;

    public R() {}

    R(final long code, final boolean success, final String message, final T data) {
        this.code = code;
        this.state = success;
        this.msg = message;
        this.data = data;
    }

    /**
     * 请求成功
     * 
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(final T data) {
        try {
            final R<T> result = new R<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getType(),
                ResultEnum.SUCCESS.getMessage(), data);
            return result;
        } catch (final Exception e) {
            return error(e);
        }
    }

    public static <T> R<T> error(final Exception ex) {
        final String format = "Message: %s, StackTrace: %s, Suppressed: %s, Cause: %s, Class: %s ";

        final String msg = String.format(format, ex.getMessage(), ex.getStackTrace(), ex.getSuppressed(), ex.getCause(),
            ex.getClass());

        return error(msg);
    }

    /**
     * 请求失败
     * 
     * @param message
     * @param <T>
     * @return
     */
    public static <T> R<T> error(final String message) {
        final R<T> result = new R<T>(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getType(), message, null);
        return result;
    }
}
