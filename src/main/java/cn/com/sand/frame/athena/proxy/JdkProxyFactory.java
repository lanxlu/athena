/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月11日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月11日 下午1:58:44
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月11日        Initailized
 */
package cn.com.sand.frame.athena.proxy;

import java.lang.reflect.Proxy;

import cn.com.sand.frame.athena.proxy.client.ProxyClientHandler;

/**
 *
 * @ClassName ：JdkProxyFactory
 * @author : SJ
 * @Date : 2016年5月11日 下午1:58:44
 * @version 1.0.0
 *
 */
public class JdkProxyFactory implements ProxyFactory
{

    private JdkProxyFactory()
    {
    }

    public static JdkProxyFactory getInstance()
    {
        return new JdkProxyFactory();
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Object obj)
    {
        ProxyClientHandler handler = new ProxyClientHandler();
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[] { (Class<T>) obj }, handler);
    }

    public enum ProxyType
    {
        CLASS("class"), INTERFACE("interface");

        private String type;

        ProxyType(String type)
        {
            this.type = type;
        }

        public String value()
        {
            return this.type;
        }
    }

}
