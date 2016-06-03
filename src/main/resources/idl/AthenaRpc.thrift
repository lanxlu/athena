namespace java cn.com.sand.frame.athena.rpc.idl

include "Athenabase.thrift"

struct AthenaRequest
{
	1: string remoteAddress,
	2: string interfaceName,
	3: string methodName,
	4: list<string> paramTypes,
	5: list<string> paramValues,
	6: string resultType,
	7: string traceId
}

struct AthenaResponse
{
	1: optional string errorCode,
	2: optional string errorMsg,
	3: optional string data,
	4: string traceId
}

service AthenaService
{
	AthenaResponse call(1:AthenaRequest request) throws (1: Athenabase.AthenaServiceException ex)
}
