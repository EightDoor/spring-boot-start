package cn.start6.zk.config.exception;

import cn.start6.zk.utils.R;
import lombok.Data;

/**
 * @author zhoukai
 */
@Data
public class UserException extends RuntimeException {
    private R r;

    /**
     * 异常处理返回信息
     * 
     * @param r
     */
    public UserException(final R r) {
        this.r = r;
    }
}
