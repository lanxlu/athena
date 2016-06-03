/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月10日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月10日 下午1:42:54
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月10日        Initailized
 */
package cn.com.sand.athena.impl;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.com.sand.athena.ThriftTest;
import cn.com.sand.athena.UserReq;
import cn.com.sand.athena.UserResp;
import cn.com.sand.frame.athena.annotation.Protocol;
import cn.com.sand.frame.athena.annotation.tag.Athena;
import cn.com.sand.frame.athena.annotation.tag.RpcService;

/**
 *
 * @ClassName ：ThriftTestImpl
 * @author : SJ
 * @Date : 2016年5月10日 下午1:42:54
 * @version 1.0.0
 *
 */
@Athena
@RpcService(protocol=Protocol.TCP,timeout=1000,version="1.0.0")
public class ThriftTestImpl implements ThriftTest
{

    /*
     * (non-Javadoc)
     *
     * @see cn.com.sand.athena.ThriftTest#hello(java.lang.String)
     */
    @Override
    public String hello(String say)
    {
        System.out.println(say+"+++++++++++++");
        return say + ": ok!";
    }

    /* (non-Javadoc)
     * @see cn.com.sand.athena.ThriftTest#test(cn.com.sand.athena.UserReq)
     */
    @Override
    public UserResp test(UserReq req)
    {
        System.out.println(req.getUsername()+"========");
        UserResp resp = new UserResp();
        resp.setUserId("123");
        return resp;
    }
    
    /* (non-Javadoc)
     * @see cn.com.sand.athena.ThriftTest#test(java.util.Map)
     */
    @Override
    public Map<String, String> test(Map<String, String> map)
    {
        System.out.println(map.get("username"));
        Map<String, String> mm = Maps.newHashMap();
        mm.put("pwd", "12");
        return mm;
    }

}
