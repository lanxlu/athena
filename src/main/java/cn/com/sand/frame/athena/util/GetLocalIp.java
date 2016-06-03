/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午2:19:23
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年4月27日        Initailized
 */
package cn.com.sand.frame.athena.util;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @ClassName ：GetLocalIp
 * @author : SJ
 * @Date : 2016年4月27日 下午2:19:23
 * @version 1.0.0
 *
 */
public class GetLocalIp
{
    private static Logger logger = LoggerFactory.getLogger(GetLocalIp.class);

    /**
     * 获取本机的IP
     *
     * @return Ip地址
     */
    public static String getLocalHostIP()
    {
        String ip = "";
        try
        {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        }
        catch (Exception ex)
        {
            logger.warn("get localhost ip fail");
        }
        return ip;
    }
}
