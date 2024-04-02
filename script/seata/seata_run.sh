#Usage: sh seata-server.sh(for linux and mac) or cmd seata-server.bat(for windows) [options]
#  Options:
#    --host, -h
#      The address is expose to registration center and other service can access seata-server via this ip
#      Default: 0.0.0.0
#    --port, -p
#      The port to listen.
#      Default: 8091
#    --storeMode, -m
#      log store mode : file、db
#      Default: file
#    --help
sh seata-server.sh -p 8091 -h 127.0.0.1 -m file