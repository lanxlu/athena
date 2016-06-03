/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月16日 下午7:11:04
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月16日        Initailized
 */
package cn.com.sand.frame.athena.factory;

import cn.com.sand.frame.athena.proxy.JdkProxyFactory;

/**
 *
 * @ClassName ：BeanFactory
 * @author : SJ
 * @Date : 2016年5月16日 下午7:11:04
 * @version 2.0.0
 *
 */
public class BeanFactory
{
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> clazz)
    {
        return (T)JdkProxyFactory.getInstance().getProxy(clazz);
    }
}
