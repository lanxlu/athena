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
public class UserResp
{
    private String userId;

    public final String getUserId()
    {
        return userId;
    }

    public final void setUserId(String userId)
    {
        this.userId = userId;
    }
}
