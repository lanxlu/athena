/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月26日 下午6:00:08
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月26日        Initailized
 */
package cn.com.sand.athena;

/**
 *
 * @ClassName ：UserReq
 * @author : SJ
 * @Date : 2016年5月26日 下午6:00:08
 * @version 2.0.0
 *
 */
public class UserReq
{
    private String username;
    private String pwd;
    public final String getUsername()
    {
        return username;
    }
    public final void setUsername(String username)
    {
        this.username = username;
    }
    public final String getPwd()
    {
        return pwd;
    }
    public final void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    @Override
    public String toString()
    {
        return "{username:" + username + "}, {pwd:" + pwd + "}";
    }
    
    
}
