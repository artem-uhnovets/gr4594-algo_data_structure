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
4("5")
5("27")
6("8")
7("26")
8("23")
9("1")
10("22")
1 --- 2 & 3
2 --- 6 & 4
4 --- 9
3 --- 11("_")
3 --- 5
5 --- 7
5 --- 12("_")
7 --- 8
7 --- 13("_")
8 --- 10
8 --- 14("_")
style 1 fill:#000
style 2 fill:#ff0000
style 3 fill:#ff0000
style 4 fill:#ff0000
style 5 fill:#ff0000
style 6 fill:#ff0000
style 7 fill:#ff0000
style 8 fill:#ff0000
style 9 fill:#ff0000
style 10 fill:#ff0000
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

```