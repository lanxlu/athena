/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月10日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月10日 下午1:42:03
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月10日        Initailized
 */
package cn.com.sand.athena;

import java.util.Map;

import cn.com.sand.frame.athena.annotation.tag.Athena;
import cn.com.sand.frame.athena.annotation.tag.RpcClient;

/**
 *
 * @ClassName ：ThriftTest
 * @author : SJ
 * @Date : 2016年5月10日 下午1:42:03
 * @version 1.0.0
 *
 */
@Athena
@RpcClient
public interface ThriftTest
{
    public String hello(String say);
    
    public UserResp test(UserReq req);
    
    public Map<String, String> test(Map<String,String> map);
}
