docker run -d --name skywalking-oap \
	--restart always \
	--security-opt seccomp=unconfined \
	-p 11800:11800 \
	-p 12800:12800  \
	-e TZ=Asia/Shanghai \
	-e SW_STORAGE=elasticsearch \
	-e SW_STORAGE_ES_CLUSTER_NODES=10.50.100.16:9200  \
	apache/skywalking-oap-server:9.1.0

docker run -d --name skywalking-ui \
  --restart always \
  --security-opt seccomp=unconfined \
  -p 8080:8080 \
  -e TZ=Asia/Shanghai  \
  --link skywalking-oap:skywalking-oap \
  -e SW_OAP_ADDRESS=http://skywalking-oap:12800 \
  apache/skywalking-ui:9.1.0


java -javaagent:/path/to/skywalking-agent/skywalking-agent.jar \
  -DSW_AGENT_COLLECTOR_BACKEND_SERVICES=127.0.0.1:11800 \
  -DSW_AGENT_NAME=GROUP::SERVICE_NAME \
  -jar yourApp.jar