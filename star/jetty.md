#jetty

## 下载及版本选择
http://www.eclipse.org/jetty/download.html
9.2.20.v20161216    Release (Java 7+)（推荐）
9.3.15.v20161220    Latest (JDK 8+)

wget http://central.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.2.20.v20161216/jetty-distribution-9.2.20.v20161216.tar.gz
##部署
tar -xzvf jetty-distribution-9.2.20.v20161216.tar.gz
mv jetty-distribution-9.2.20.v20161216 jetty
cd jetty
##启动
java -jar start.jar --daemon &
## 修改启动项配置 start.ini 文件   端口等配置
访问http://localhost:8080/
##部署demo.war
上传demo.war到webapps目录下
访问http://localhost:8080/demo
