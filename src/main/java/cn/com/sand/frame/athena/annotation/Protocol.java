/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午2:26:08
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年4月27日        Initailized
 */
package cn.com.sand.frame.athena.annotation;

/**
 *
 * @ClassName ：Protocol
 * @author : SJ
 * @Date : 2016年4月27日 下午2:26:08
 * @version 1.0.0
 *
 */
public enum Protocol
{
    TCP("tcp"), HTTP("http");

    private final String type;

    private Protocol(String type)
    {
        this.type = type;
    }

    public String value()
    {
        return this.type;
    }
}
