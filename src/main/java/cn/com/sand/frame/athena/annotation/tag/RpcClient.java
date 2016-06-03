/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午2:24:33
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

/**
 *
 * @ClassName ：RpcClient
 * @author : SJ
 * @Date : 2016年4月27日 下午2:24:33
 * @version 1.0.0
 *
 */
@Documented
@Target(value = { FIELD, PACKAGE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcClient
{

}
