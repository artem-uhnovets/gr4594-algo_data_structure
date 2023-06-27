___
```
------Node{value=27,color=RED}
---------Node{value=26,color=RED}
------------Node{value=23,color=RED}
---------------Node{value=22,color=RED}
---Node{value=14,color=RED}
Node{value=11,color=BLACK}
------Node{value=8,color=RED}
---Node{value=6,color=RED}
------Node{value=5,color=RED}
---------Node{value=1,color=RED}
```
```mermaid
flowchart TB
subgraph Before
direction TB
1("11")
2("6")
3("14")
4("8")
5("27")
6("5")
7("26")
8("23")
9("1")
10("22")
1 --- 2 & 3
2 --- 6 & 4
6 --- 9
6 --- 15("-")
3 --- 11("_")
3 --- 5
5 --- 7
5 --- 12("_")
7 --- 8
7 --- 13("_")
8 --- 10
8 --- 14("_")
style 1 fill:#000
style 2 fill:#bc0000
style 3 fill:#bc0000
style 4 fill:#bc0000
style 5 fill:#bc0000
style 6 fill:#bc0000
style 7 fill:#bc0000
style 8 fill:#bc0000
style 9 fill:#bc0000
style 10 fill:#bc0000
end
```
___
```
------Node{value=27,color=BLACK}
---Node{value=26,color=BLACK}
---------Node{value=23,color=BLACK}
------Node{value=22,color=RED}
---------Node{value=14,color=BLACK}
Node{value=11,color=BLACK}
------Node{value=8,color=BLACK}
---Node{value=6,color=BLACK}
------Node{value=5,color=BLACK}
---------Node{value=1,color=RED}
```
```mermaid
flowchart TB
subgraph After
direction TB
11
14
6
8
27
5
26
23
1
22

11 --- 6 & 26
6 --- 5 & 8
26 --- 22 & 27
5 --- 1
22 --- 14 & 23

style 11 fill:#000,color:#fff
style 14 fill:#000,color:#fff
style 6 fill:#000,color:#fff
style 8 fill:#000,color:#fff
style 27 fill:#000,color:#fff
style 5 fill:#000,color:#fff
style 26 fill:#000,color:#fff
style 23 fill:#000,color:#fff
style 1 fill:#bc0000
style 22 fill:#bc0000
end
```
```mermaid
flowchart TB
subgraph After
direction TB

11 --- 6 --- 5 --- 1 --- node1[null]
1 --- node2[null]
5 --- node3[null]
6 --- 8 --- node4[null]
8 --- node5[null]
11 --- 26 --- 22 --- 14 --- node6[null]
14 --- node7[null]
22 --- 23 --- node8[null]
23 --- node9[null]
26 --- 27 --- node10[null]
27 --- node12[null]

style 11 fill:#000,color:#fff
style 14 fill:#000,color:#fff
style 6 fill:#000,color:#fff
style 8 fill:#000,color:#fff
style 27 fill:#000,color:#fff
style 5 fill:#000,color:#fff
style 26 fill:#000,color:#fff
style 23 fill:#000,color:#fff
style 1 fill:#bc0000
style 22 fill:#bc0000
end
```

```mermaid
flowchart TB
subgraph After
direction TB

11 --- 6 --- 5 --- 1 --- node1[" "]
1 --- node2[" "]
5 --- node3[" "]
6 --- 8 --- node4[" "]
8 --- node5[" "]
11 --- 26 --- 22 --- 14 --- node6[" "]
14 --- node7[" "]
22 --- 23 --- node8[" "]
23 --- node9[" "]
26 --- 27 --- node10[" "]
27 --- node12[" "]

style 11 fill:#000,color:#fff
style 14 fill:#000,color:#fff
style 6 fill:#000,color:#fff
style 8 fill:#000,color:#fff
style 27 fill:#000,color:#fff
style 5 fill:#000,color:#fff
style 26 fill:#000,color:#fff
style 23 fill:#000,color:#fff
style 1 fill:#bc0000,color:#fff
style 22 fill:#bc0000,color:#fff
end
```
```mermaid
flowchart TB
subgraph After
direction TB

11 --- 6
11 --- 26
6 --- 5
6 --- 8
26 --- 22
26 --- 27
5 --- 1
5 --- node4[" "]
8 --- node5[" "]
8 --- node6[" "]
22 --- 14
22 --- 23
27 --- node8[" "]
27 --- node9[" "]
style 11 fill:#000,color:#fff
style 14 fill:#000,color:#fff
style 6 fill:#000,color:#fff
style 8 fill:#000,color:#fff
style 27 fill:#000,color:#fff
style 5 fill:#000,color:#fff
style 26 fill:#000,color:#fff
style 23 fill:#000,color:#fff
style 1 fill:#bc0000,color:#fff
style 22 fill:#bc0000,color:#fff
end
```