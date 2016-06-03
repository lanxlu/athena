/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014 Project : athena $Id$
 * $Revision$ Last Changed by SJ at 2016年5月16日 下午6:59:04 $URL$
 * 
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2016年5月16日
 * Initailized
 */
package cn.com.sand.frame.athena.boot;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.com.sand.component.discover.zookeeper.core.CuratorManager;
import cn.com.sand.component.discover.zookeeper.core.URL;
import cn.com.sand.frame.athena.annotation.AnnotationHelp;
import cn.com.sand.frame.athena.annotation.Category;
import cn.com.sand.frame.athena.util.GetLocalIp;

/**
 *
 * @ClassName ：ClientBoot
 * @author : SJ
 * @Date : 2016年5月16日 下午6:59:04
 * @version 2.0.0
 *
 */
public class ClientBoot
{
    private String            connectString;
    private String            scanPath;
    private static ClientBoot clientBoot;

    public synchronized static ClientBoot create()
    {
        if (clientBoot == null)
        {
            clientBoot = new ClientBoot();
        }
        return clientBoot;
    }

    public void start()
    {
        if (StringUtils.isNotBlank(connectString))
        {
            CuratorManager.init().connectString(connectString).start();
        }
        if (StringUtils.isNotBlank(scanPath))
        {
            List<URL> list = AnnotationHelp.getUrls(scanPath);
            String ip = GetLocalIp.getLocalHostIP();
            for (int i = 0; i < list.size(); i++)
            {
                URL url = list.get(i);
                url.setIp(ip);
                if (url.getCategory().equals(Category.CLIENT.value()))
                {
                    CuratorManager.init().regClient(url);
                }
            }
        }
    }

    public ClientBoot connectString(String connectString)
    {
        this.connectString = connectString;
        return this;
    }

    /**
     * 扫描服务api
     * 
     * @param scanPath
     *            包路径
     * @return
     */
    public ClientBoot scanPath(String scanPath)
    {
        this.scanPath = scanPath;
        return this;
    }
}
