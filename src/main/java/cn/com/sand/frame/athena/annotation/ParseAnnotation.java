/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日 Project : athena $Id$
 * $Revision$ Last Changed by SJ at 2016年4月27日 下午2:08:32 $URL$
 *
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2016年4月27日
 * Initailized
 */
package cn.com.sand.frame.athena.annotation;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sand.component.discover.zookeeper.core.URL;
import cn.com.sand.frame.athena.annotation.tag.Athena;
import cn.com.sand.frame.athena.annotation.tag.RpcClient;
import cn.com.sand.frame.athena.annotation.tag.RpcService;
import cn.com.sand.frame.athena.proxy.service.ProxyCache;

/**
 *
 * @ClassName ：ParseAnnotation
 * @author : SJ
 * @Date : 2016年4月27日 下午2:08:32
 * @version 1.0.0
 *
 */
public class ParseAnnotation
{
    private static final Logger logger = LoggerFactory.getLogger(ParseAnnotation.class);

    public static URL parse(Class<?> clazz)
    {
        Athena athena = clazz.getAnnotation(Athena.class);
        if (athena != null)
        {
            logger.info("parse class ---> " + clazz.getName());
            URL url = new URL();
            RpcService service = clazz.getAnnotation(RpcService.class);
            if (service != null)
            {
                String value = StringUtils.isBlank(athena.value()) ? clazz.getInterfaces()[0].getName()
                        : athena.value();
                url.setNode(value);
                url.setCategory(Category.SERVICE.value());
                url.setProtocol(service.protocol().value());
                url.setRetries(service.retries());
                url.setTimeout(service.timeout());
                url.setVersion(service.version());
                ProxyCache.init().put(value, clazz.getName());
            }
            else
            {
                RpcClient client = clazz.getAnnotation(RpcClient.class);
                if (client != null)
                {
                    String value = StringUtils.isBlank(athena.value()) ? clazz.getName() : athena.value();
                    url.setNode(value);
                    url.setCategory(Category.CLIENT.value());
                }
            }
            return url;
        }

        return null;
    }
}
