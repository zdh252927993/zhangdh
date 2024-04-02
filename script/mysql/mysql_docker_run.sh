#docker pull mysql
docker stop mysql
docker rm mysql
docker run -d -p 3306:3306  --restart=always  --privileged=true --name mysql  -v  /Users/zhangdh/Documents/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD="123456" -d mysql

# 8.0mysql 鉴权
#ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';