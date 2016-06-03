/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月13日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月13日 上午11:26:58
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月13日        Initailized
 */
package cn.com.sand.athena;

import cn.com.sand.frame.athena.annotation.tag.Athena;
import cn.com.sand.frame.athena.annotation.tag.RpcClient;

/**
 *
 * @ClassName ：ThriftTest2
 * @author : SJ
 * @Date : 2016年5月13日 上午11:26:58
 * @version 1.0.0
 *
 */
@Athena
@RpcClient
public interface ThriftTest2
{
    public String test(String tt);
}
