/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午1:59:46
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
 * @ClassName ：Category
 * @author : SJ
 * @Date : 2016年4月27日 下午1:59:46
 * @version 1.0.0
 *
 */
public enum Category
{
    SERVICE("services"), CLIENT("client");

    private final String type;

    private Category(String type)
    {
        this.type = type;
    }

    public String value()
    {
        return this.type;
    }

}
