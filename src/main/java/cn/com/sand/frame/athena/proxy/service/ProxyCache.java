/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014 Project : athena $Id$
 * $Revision$ Last Changed by SJ at 2016年5月16日 下午6:00:07 $URL$
 * 
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2016年5月16日
 * Initailized
 */
package cn.com.sand.frame.athena.proxy.service;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 *
 * @ClassName ：ProxyCache
 * @author : SJ
 * @Date : 2016年5月16日 下午6:00:07
 * @version 2.0.0
 *
 */
public class ProxyCache
{
    private static Map<String, String> cache = Maps.newConcurrentMap();
    private static ProxyCache          instance;

    public static ProxyCache init()
    {
        if (instance == null)
        {
            instance = new ProxyCache();
        }
        return instance;
    }

    public void put(String key, String value)
    {
        cache.put(key, value);
    }

    public String get(String key)
    {
        return cache.get(key);
    }
}
