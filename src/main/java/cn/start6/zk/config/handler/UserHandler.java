package cn.start6.zk.config.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.start6.zk.config.exception.UserException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoukai
 */
@Slf4j
@RestControllerAdvice
public class UserHandler {
    /**
     * 校验错误拦截处理
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public Object handle(final UserException e) {
        return e.getR();
    }
}
