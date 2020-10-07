### 如何将本地项目上传到 git 仓库中
1. 打开 github，新建一个仓库来存放项目
2. 复制仓库链接 （https://github.com/Jasion-han/Leetcode.git）
3. 找到要上传的项目文件，比如 Leetcode 就是我要上传到仓库上的文件
4. 在项目根目录上右击，选择 Git Bash Here 命令窗口输入以下命令
    - 1). git status ，查看当前项目在 git 中的状态
    - 2). git init ，初始化仓库，将这个目录变成 git 可以管理的仓库
    - 3). git commit -m "本次提交信息" ，命令将文件提交到仓库
    - 4). git remote add origin 远程仓库的地址 ，关联目标仓库
    - 5). git remote -v ，查看所提交文件信息
    - 6). git pull --rebase origin master ，将文件与远程仓库进行合并
    - 7). git push -u origin master ，将本地文件推送到 github 仓库中，按照提示输入用户名和密码即可。

参考博文：

[使用Git将Java项目上传到GitHub上、删除仓库及从GitHub上下载项目](https://blog.csdn.net/wan_ide/article/details/98878411?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160200035819195240455606%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=160200035819195240455606&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v28-14-98878411.pc_first_rank_v2_rank_v28&utm_term=%E5%B0%86github%E6%96%87%E4%BB%B6%E9%83%BD%E6%94%B9%E4%B8%BAjava&spm=1018.2118.3001.4187)

[将本地已有的一个项目上传到新建的git仓库的方法](https://blog.csdn.net/ymmccc/article/details/84111500?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param)
