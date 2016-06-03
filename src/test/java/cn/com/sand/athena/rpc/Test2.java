/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月11日 Project : athena $Id$
 * $Revision$ Last Changed by SJ at 2016年5月11日 下午3:18:47 $URL$
 *
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2016年5月11日
 * Initailized
 */
package cn.com.sand.athena.rpc;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.com.sand.athena.ThriftTest;
import cn.com.sand.athena.ThriftTest2;
import cn.com.sand.athena.UserReq;
import cn.com.sand.athena.UserResp;
import cn.com.sand.frame.athena.boot.ClientBoot;
import cn.com.sand.frame.athena.factory.BeanFactory;

/**
 *
 * @ClassName ：Test2
 * @author : SJ
 * @Date : 2016年5月11日 下午3:18:47
 * @version 1.0.0
 *
 */
public class Test2
{

    public static void main(String[] args) throws Exception
    {
        ClientBoot.create().connectString("127.0.0.1:2181").scanPath("cn.com.sand.athena").start();

        for (int i = 0; i < 5; i++)
        {
            
            ThriftTest service1 = BeanFactory.getBean(ThriftTest.class);
//            Map<String, String> map = Maps.newHashMap();
//            map.put("username", "wwww");
//            Map<String, String> mm = service1.test(map);
//            System.out.println(mm.get("pwd"));
//            String res1 = service1.hello("are you ok? ");
//            System.out.println(res1);
            UserReq req = new UserReq();
            req.setUsername("wwww");
            UserResp resp = service1.test(req);
            System.out.println("=====" + resp.getUserId());
        }
//        ThriftTest2 service = BeanFactory.getBean(ThriftTest2.class);
//        String res = service.test("are you ok? ");
//        System.out.println(res);

        // ThriftTest2 service2 =
        // JdkProxyFactory.getInstance().getProxy(ThriftTest2.class);
        // String res2 = service2.test("测试");
        // System.out.println(res2);
        //
        // Set<URL> lives = CuratorManager.getLives();
        // for (URL url : lives)
        // {
        // System.out.println("====" + JSONObject.toJSONString(url));
        // }
        Thread.sleep(5000000);

    }
}
