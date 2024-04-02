brew install mysql@5.7
brew services start mysql@5.7
#echo 'export PATH="/usr/local/opt/mysql@5.7/bin:$PATH"' >> ~/.bash_profile
echo 'export PATH="/opt/homebrew/opt/mysql@5.7/bin:$PATH"' >> ~/.bash_profile

mysqld --initialize --explicit_defaults_for_timestamp --datadir=/usr/local/mysql/data
#生成/tmp/mysql.sock
mysqld_safe&

source ~/.bash_profile
mysql_secure_installation

mysql -uroot -p