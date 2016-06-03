/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014 Project :
 * multichannel-core-deploy-adapter $Id$ $Revision$ Last Changed by SJ at
 * 2015年10月20日 下午8:26:31 $URL$
 *
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2015年10月20日
 * Initailized
 */
package cn.com.sand.frame.athena.rpc.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sand.frame.athena.rpc.idl.AthenaRequest;
import cn.com.sand.frame.athena.rpc.idl.AthenaResponse;
import cn.com.sand.frame.athena.rpc.idl.AthenaService;
import cn.com.sand.frame.athena.rpc.idl.AthenaServiceException;

/**
 *
 * @ClassName ：AthenaThriftClient
 * @author : SJ
 * @Date : 2015年10月20日 下午8:26:31
 * @version 2.0.0
 *
 */
public class AthenaThriftClient implements ThriftClient<AthenaRequest, AthenaResponse>
{
    private Logger       logger = LoggerFactory.getLogger(AthenaThriftClient.class);
    private final String thriftHost;
    private final int    thriftPort;
    private final int    thriftTimeout;

    public AthenaThriftClient(String thriftHost, int thriftPort, int thriftTimeout)
    {
        this.thriftHost = thriftHost;
        this.thriftPort = thriftPort;
        this.thriftTimeout = thriftTimeout;
    }

    public AthenaResponse invoke(AthenaRequest request)
    {
        AthenaResponse response = null;
        TTransport transport = null;
        try
        {

            /** use nio client */
            transport = new TFramedTransport(
                    new TSocket(thriftHost, thriftPort, thriftTimeout));
            transport.open();

            /** use compact protocol **/
            TProtocol protocol = new TCompactProtocol(transport);
            AthenaService.Client client = new AthenaService.Client(protocol);

            /** reqeust cpay server */
            response = client.call(request);
        }
        catch (TTransportException e)
        {
            logger.error("connect thrift server({}:{}) fail, cause by :{}",
                    new Object[] { thriftHost, thriftPort, e.getMessage() });
        }
        catch (AthenaServiceException ex)
        {
            logger.error("call service fail, cause by :{},{}",
                    new Object[] { ex.getWhat(), ex.getWhy() });
        }
        catch (TException e)
        {
            logger.error("rpc call server({}:{}) fail, cause by :{}",
                    new Object[] { thriftHost, thriftPort, e.getMessage() });
        }
        finally
        {
            /** must release resource, not forget!! */
            if (transport != null && transport.isOpen())
                transport.close();
        }
        return response;
    }
}
