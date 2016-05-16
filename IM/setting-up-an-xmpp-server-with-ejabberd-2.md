## 基于ejabberd的IM服务搭建
----------------------------

###安装 erlang  

yum install erlang

RHEL/CentOS Dependencies

yum install gcc glibc-devel make ncurses-devel openssl-devel autoconf automake

wget http://erlang.org/download/otp_src_17.5.tar.gz
tar zxvf otp_src_17.5.tar.gz
cd otp_src_17.5
./configure && make && sudo make install

### 安装配置ejabberd
```shell
yum install -y gcc libyaml libyaml-devel openssl  expat expat-devel openssl zlib make ImageMagick ImageMagick-devel gcc-c++
tar -xvf ejabberd-15.11.tar
cd ejabberd-15.11
./configure --enable-mysql
make
sudo make install   (use administrator role)
```
make 需要git客户端且可以联网


### ejabberd 命令
ejabberdctl register admin 10.16.123.17 admin 注册一个管理账户密码为admin 我本机设置为[admin]
ejabberdctl start 
ejabberdctl stop  
ejabberdctl status  
###查看日志
cat /var/log/ejabberd/ejabberd.log

###参考文档
http://www.netspective.com/uncategorized/2013/05/02/setting-up-an-xmpp-server-with-ejabberd-2/  
https://blog.process-one.net/switch-ejabberd-configuration-to-yaml/ 
https://docs.ejabberd.im/admin/guide/configuration/#host-names  
http://blog.fnil.net/index.php/archives/276/ 优化笔记  
