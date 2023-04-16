# Library-Sys
图书管理系统

// TODO

## 推荐系统
[数据集（Google Drive）](https://drive.google.com/drive/folders/1PqGKcCAJw5C5rjeTIJKk5XWICCU7rpyZ?usp=share_link)
[源数据来源](https://aistudio.baidu.com/aistudio/datasetdetail/7492/0)


|             文件             | 描述                                          |
|:--------------------------:|:--------------------------------------------|
|        bookdata.dat        | 为书籍标签原始数据集，来源豆瓣官网爬取                         |
|        userdata.dat        | 为用户评分原始数据集，来源为北大开放研究数据平台                    |
|        clusters.pkl        | 为用户聚类的数据结果，通过pickle包直接保存，程序运行时直接加载，避免每次重新生成 |
| userdata.pkl bookdata.pkl  | 均为原始数据集预处理后的结果，通过pickle保存，程序运行时直接加载         |
 
