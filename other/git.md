###git使用
------------------------------


git install on centos

referecence
http://www.cnblogs.com/shenliang123/p/3824383.html
https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control



安全配置相关
禁用shell登录
出于安全考虑，第二步创建的git用户不允许登录shell，这可以通过编辑/etc/passwd文件完成。找到类似下面的一行：

git:x:1001:1001:,,,:/home/git:/bin/bash
改为：

git:x:1001:1001:,,,:/home/git:/usr/bin/git-shell
这样，git用户可以正常通过ssh使用git，但无法登录shell，因为我们为git用户指定的git-shell每次一登录就自动退出。



git clone git@192.168.1.117:opt/gitStore/ly.git


git  in eclipse
http://blog.csdn.net/hhhccckkk/article/details/10458159

http://blog.csdn.net/wisgood/article/details/12949131
http://blog.csdn.net/wisgood/article/details/12949477
http://blog.csdn.net/hhhccckkk/article/details/10458159
eclipse EGit 指南
http://wiki.eclipse.org/EGit/User_Guide#Getting_Started
Eclipse使用git最基本流程 - 张万帆
http://www.tuicool.com/articles/fArInam

1）  服务端创建仓库  sample.git 为仓库名称

sudo git init --bare ly.git


2）客户端

关联一个远程仓库

克隆
git clone git@xx:/opt/gitStore/ly.git
push到服务端地址
ssh://git@xx/opt/gitStore/ly.git

克隆
ssh://git@xx/opt/gitStore/ly.git

### git 手把手学习
https://try.github.io/levels/1/challenges/1
### github代码搜索技巧
国内牛人：http://outofmemory.cn/github/
国外牛人：https://github-ranking.com/
技巧：http://blog.csdn.net/laokdidiao/article/details/51442835 
