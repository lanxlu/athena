/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月5日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月5日 下午5:19:19
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月5日        Initailized
 */
package cn.com.sand.athena;

import cn.com.sand.frame.athena.boot.ServBoot;

/**
 *
 * @ClassName ：ThriftServTest
 * @author : SJ
 * @Date : 2016年5月5日 下午5:19:19
 * @version 1.0.0
 *
 */
public class ThriftServTest
{
    public static void main(String[] args)
    {
        ServBoot serv = new ServBoot("127.0.0.1:2181", "cn.com.sand.athena");
        serv.start(8080, 1, 1, 1, "", 1);
    }
}
