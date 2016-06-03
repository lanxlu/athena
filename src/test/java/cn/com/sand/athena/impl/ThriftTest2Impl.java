/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月13日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月13日 上午11:27:19
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月13日        Initailized
 */
package cn.com.sand.athena.impl;

import cn.com.sand.athena.ThriftTest2;
import cn.com.sand.frame.athena.annotation.Protocol;
import cn.com.sand.frame.athena.annotation.tag.Athena;
import cn.com.sand.frame.athena.annotation.tag.RpcService;

/**
 *
 * @ClassName ：ThriftTest2Impl
 * @author : SJ
 * @Date : 2016年5月13日 上午11:27:19
 * @version 1.0.0
 *
 */
@Athena
@RpcService(protocol=Protocol.TCP,timeout=1000,version="1.0.0")
public class ThriftTest2Impl implements ThriftTest2
{

    /* (non-Javadoc)
     * @see cn.com.sand.athena.ThriftTest2#test(java.lang.String)
     */
    @Override
    public String test(String tt)
    {

        return "test22 :" + tt;
    }

}
