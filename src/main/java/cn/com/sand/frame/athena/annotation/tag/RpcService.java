/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午2:14:29
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年4月27日        Initailized
 */
package cn.com.sand.frame.athena.annotation.tag;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.com.sand.frame.athena.annotation.Protocol;

/**
 *
 * @ClassName ：RpcService
 * @author : SJ
 * @Date : 2016年4月27日 下午2:14:29
 * @version 1.0.0
 *
 */
@Documented
@Target(value = { FIELD, PACKAGE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService
{
    public int timeout() default 0;

    public int retries() default 0;

    public String version() default "";

    public Protocol protocol() default Protocol.TCP;
}
