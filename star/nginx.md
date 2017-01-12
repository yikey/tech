##nginx配置日常日志
### 配置openssl未生效问题
配置了nginx.conf 文件 端口未监听到443端口，nginx -s reload 命令显然是有问题的
执行nginx -s stop && nginx 
443端口监听成功
