/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014 Project : athena $Id$
 * $Revision$ Last Changed by SJ at 2016年5月16日 下午7:44:39 $URL$
 * 
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2016年5月16日
 * Initailized
 */
package cn.com.sand.frame.athena.boot;

import java.util.List;

import org.apache.thrift.TProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sand.component.discover.zookeeper.core.CuratorManager;
import cn.com.sand.component.discover.zookeeper.core.URL;
import cn.com.sand.frame.athena.annotation.AnnotationHelp;
import cn.com.sand.frame.athena.annotation.Category;
import cn.com.sand.frame.athena.rpc.AthenaServiceHandler;
import cn.com.sand.frame.athena.rpc.idl.AthenaService;
import cn.com.sand.frame.athena.rpc.service.ThriftServer;
import cn.com.sand.frame.athena.util.GetLocalIp;

/**
 *
 * @ClassName ：ServBoot
 * @author : SJ
 * @Date : 2016年5月16日 下午7:44:39
 * @version 2.0.0
 *
 */
public class ServBoot extends ThriftServer
{

    private static Logger logger = LoggerFactory.getLogger(ServBoot.class);
    private String        connectString;
    private String        packPath;

    /**
     * 启动服务
     * 
     * @param connectString
     *            zookeeper 地址:端口
     * @param packPath
     *            扫描包路径
     */
    public ServBoot(String connectString, String packPath)
    {
        this.connectString = connectString;
        this.packPath = packPath;
    }

    public void start(int port, int selectorThreads, int workThreads, int acceptQueueSizePerThread, String policy,
            int fixedThreadPoolSize)
    {
        regServ(port, 10000);
        super.start(port, selectorThreads, workThreads, acceptQueueSizePerThread, policy, fixedThreadPoolSize);
    }

    public void start(int port, int selectorThreads, int workThreads, int acceptQueueSizePerThread, String policy,
            int fixedThreadPoolSize, int timeout)
    {
        regServ(port, timeout);
        super.start(port, selectorThreads, workThreads, acceptQueueSizePerThread, policy, fixedThreadPoolSize);
    }

    private void regServ(int port, int timeout)
    {
        CuratorManager.init().connectString(connectString).start();

        List<URL> urlist = AnnotationHelp.getUrls(packPath);
        String ip = GetLocalIp.getLocalHostIP();
        for (int i = 0; i < urlist.size(); i++)
        {
            URL url = urlist.get(i);
            url.setPort(String.valueOf(port));
            url.setTimeout(timeout);
            url.setIp(ip);
            if (url.getCategory().equals(Category.SERVICE.value()))
            {
                CuratorManager.init().regService(url);
                logger.info("register service {} success", url.toString());
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.sand.frame.athena.rpc.service.ThriftServer#getProcesser()
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public TProcessor getProcesser()
    {
        // TODO Auto-generated method stub
        return new AthenaService.Processor(new AthenaServiceHandler());
    }

}
