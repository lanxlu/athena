/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月5日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月5日 上午9:46:55
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月5日        Initailized
 */
package cn.com.sand.frame.athena.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sand.component.discover.zookeeper.core.CuratorManager;
import cn.com.sand.frame.athena.rpc.client.AthenaThriftClient;
import cn.com.sand.frame.athena.rpc.client.IThriftHandler;
import cn.com.sand.frame.athena.rpc.client.ThriftClientFactory;
import cn.com.sand.frame.athena.rpc.idl.AthenaRequest;
import cn.com.sand.frame.athena.rpc.idl.AthenaResponse;

/**
 *
 * @ClassName ：AthenaClientHandler
 * @author : SJ
 * @Date : 2016年5月5日 上午9:46:55
 * @version 1.0.0
 *
 */
public class AthenaClientHandler implements IThriftHandler<AthenaRequest, AthenaResponse>
{
    private static Logger            logger = LoggerFactory.getLogger(AthenaClientHandler.class);
    private final AthenaThriftClient client;

    public AthenaClientHandler(String servId)
    {
        String thriftHost = CuratorManager.init().getIp(servId);
        String thriftPort = CuratorManager.init().getPort(servId);
        int timeout = CuratorManager.init().getTimeOut(servId);
        this.client = (AthenaThriftClient) ThriftClientFactory.builder().host(thriftHost)
                .port(Integer.valueOf(thriftPort)).timeout(timeout).create();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * cn.com.sand.component.rpc.thrift.client.IThriftHandler#doHandle(java.
     * lang.Object)
     */
    @Override
    public AthenaResponse doHandle(AthenaRequest request)
    {
        logger.info("request ---> " + request);
        AthenaResponse mcResponse = client.invoke(request);
        logger.info("response ---> " + mcResponse);
        return mcResponse;
    }

}
