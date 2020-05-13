# youtube-parser

This programm can parse YouTube channels, analyze topics of videos and show rated videos (TOP positions).
###
For analyzing app uses the next algorithm:

```
C - subscribers count
P - views count
T - video age (in month)
K - views coefficient
R - rate
```
``` K = 100 *P/C ``` ``` R = K*10/T ```
### Main formula:
```
R = 1000 * P / C * T
```

## How to use it?
1) Open ```default.conf``` 
2) Write the channels ids into the channels.ru/channels.en arrays.
3) Run Main.java
