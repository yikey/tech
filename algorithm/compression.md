##常见压缩算法
---------------



| Algorithm      | `remaining`   | `Encoding`  | `Decoding` |
| --------------- |:-------------------:|:------------------:|:-----------------------:|
| GZIP | 13.4% | 21 MB/s | 118 MB/s |
| LZO  | 20.5% | 135 MB/s |410 MB/s |
| Zippy/Snappy  | 22.2% | 172 MB/s | 409 MB/s |


Gzip应用于http压缩传输

Snappy前身为Zippy，现已被Google开源，广泛应用于google内部项目，还常见应用于大数据相关组件Hadoop HBase ，以极快的压缩时间加锁比文明  
[Snappy算法-java版实现](https://github.com/xerial/snappy-java)
