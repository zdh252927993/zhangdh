#docker pull seataio/seata-server
docker stop seata-server
docker rm seata-server
#docker run -d -p 8091:8091 -p 7091:7091 --network=localhost -v /Users/zhangdh/IdeaProjects/yinshi/zhangdh/script/seata/bootstrap.yml:/seata-server/resources/bootstrap.yml -e SEATA_IP=10.1.61.135 --name seata-server seataio/seata-server
docker run -d -p 8091:8091 -p 7091:7091 -v /home/app/seata-ga/application.yml:/seata-server/resources/application.yml -v /home/app/seata-ga/logs:/root/logs -e SEATA_IP=10.50.100.155 --name seata-server-ga seataio/seata-server:2.1.0

#you can visit seata console UI on http://127.0.0.1:7091
#seata/seata

