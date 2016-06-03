/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月11日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月11日 下午2:00:13
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月11日        Initailized
 */
package cn.com.sand.frame.athena.proxy;

/**
 *
 * @ClassName ：ProxyFactory
 * @author : SJ
 * @Date : 2016年5月11日 下午2:00:13
 * @version 1.0.0
 *
 */
public interface ProxyFactory
{
    public <T> T getProxy(Object obj);
}
