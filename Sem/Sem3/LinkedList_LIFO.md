# Односвязный
```mermaid
---
title: "Порядок добавления значений в LinkedList LIFO"
---
flowchart LR
1("1\n---\n1")
2("3\n---\n2")
3("2\n---\n3")
4("4\n---\n4")
5("9\n---\n5")
subgraph HEAD
6("7\n---\n6")
end
1 --> 2 --> 3 --> 4 --> 5 --> 6
```
```mermaid
flowchart TB
1[("1")]
2[("3")]
3[("2")]
4[("4")]
5[("9")]
subgraph HEAD
6[("7")]
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
```
`head` является последним добавленным `узлом`

главным свойством LinkedList LIFO является `узел head`, это своего рода точка отсчета / координат для движения по списку

двигаться мы можем только начиная с `head`

у узлов свойствами являются `value`-значения и `узел next`, который ссылается на предыдущий добавленный `узел`

```mermaid
---
title: "Порядок вывода в LinkedList LIFO"
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
```
```mermaid
---
title: "Смена HEAD при добавлении нового узла в начало списка"
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
subgraph ADD
direction BT
style next text-align:justify
7("10")
next("node.next = head\n head = node")
next
end
7 --> 6 --> 5 --> 4 --> 3 --> 2 --> 1
ADD <--> HEAD
```
```java
node.next = head
// так как список выводиться методом LIFO, то ссылка на узел next является текущий head(который мы еще не поменяли), т.е. узел со значением 7

head = node
// теперь мы меняем узел head на новый добавленный узел со значением 10
```
При добавлении нового узла в конец списка необходимо будет пройти весь список до самого первого узла через свойство `next`
```mermaid
---
title: "Добавление нового узла в конец списка"
---
flowchart LR
subgraph END_list
style 1prop text-align:justify
1("1")
1prop("node.next=null")
end
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
subgraph ADD
direction BT
7("10")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1 --> 7
```
```mermaid
---
title: "REVERSE"
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
7("7")
8("9")
9("4")
10("2")
11("3")
subgraph HEADrev
12("1")
end
subgraph HEAD
6("7")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
12 --> 11 --> 10 --> 9 --> 8 --> 7
```
```mermaid
---
title: "REVERSE - нужно перемещать HEAD ?!"
---
flowchart LR
subgraph 5step
1("1")
end
subgraph 4step
2("3")
end
subgraph 3step
3("2")
end
subgraph 2step
4("4")
end
subgraph 1step
5("9")
end
subgraph HEAD
6("7")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
HEAD --> 1step --> 2step --> 3step --> 4step --> 5step
```
Получается, что `узел head` и `узел next`(одним из свойств узлов `Node`) являются нашими единственными инструментами по **передвижению** по списку
```mermaid
---
title: "ввести переменную Node current (cur) ?!"
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph CUR=HEAD
6("7")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
```
Перемещать каждый раз `head`, который `cur` или `cur`, который `head` в конец списка?!
```mermaid
---
title: ""
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
6("7")
5 --> 6 --> 4 --> 3 --> 2 --> 1
```
`head` должен всегда оставаться в начале списка, чтобы в дальнейшем мы могли использоваться список корректно
значит перемещаться нужно через `cur`, которая в начале была `head`
```mermaid
---
title: ""
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
6("7")
subgraph HEAD
5("9")
end
5 --> 6 --> 4 --> 3 --> 2 --> 1
```
```mermaid
---
title: "Сначало - еще раз"
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
6 -->|cur.next| 5 -->|cur.next.next| 4 --> 3 --> 2 --> 1
6 -->|поменять свойство next| 4
```
```java
next = cur.next;
// next.next соответственно наследует cur.next.next т.е. узел со знач 4
after = next.next;
```
```mermaid
---
title: ""
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
6 -->|cur.next=after| 4 --> 3 --> 2 --> 1
5 --> 4

```
```mermaid
---
title: ""
---
flowchart LR
1("1")
2("3")
3("2")
4("4")
5("9")
subgraph HEAD
6("7")
end
5 ==>|next.next=cur| 6 -->|cur.next=after| 4 --> 3 --> 2 --> 1
5 x--меняем next--x 4

```
```java
//---------до цикла----------
cur = head; // задаем начальный узел движения по списку перед циклом
next = cur.next; // попробовать использовать next.next в цикле?!
//---------------------------

// 1. нужно у узла cur со значением 7 поменять свойство next на узел со значением 4
cur.next = after;

// 2. у узла со значением 9 поменять свойство next на узел со значением 9
next.next = cur;

// 3. как поступить с head?!
// head надо поменять с узла 7 на 9, но делать это нужно только 1 раз в начале цикла
// head всегда должен быть в начале списка
head = next;
```
```mermaid
---
title: ""
---
flowchart LR
subgraph "LoopArea"
1("1")
2("3")
3("2")
subgraph "\n\n\nnext"
4("4")
end
subgraph "\n\n\ncur"
5("9")
end
end
subgraph "HEAD\n\n\nbefore"
6("7")
end
6 --> 5 --> 4 --> 3 --> 2 --> 1
```
___
Что если цикл начинать со след. узла от узла `head`!?!?!?! тогда
```java
// начальные переменные
before = head;
cur = head.next;
next = cur.next;

// действия рокировки
// 1. узел 7 с 9 меняем на 4
before.next = next;

// 2. узел 9 с 4 меняем на 7
cur.next = before;

// 3. При 1ой итерации меняем head c узла 7 на 9
if (i==1) { head = cur; }
// или
if (head == before) { head = cur; }
```
```mermaid
---
title: ""
---
flowchart LR
subgraph "LoopArea"
1("1")
2("3")
3("2")
subgraph "\n\n\nnext"
4("4")
end
subgraph "\n\n\nbefore"
6("7")
end
end
subgraph "HEAD\n\n\ncur"
5("9")
end

5 --> 6 --> 4 --> 3 --> 2 --> 1
```
```java
// присуждение новых узлов для before cur и next
cur = before.next;
next = cur.next;
```
```mermaid
---
title: ""
---
flowchart LR
subgraph "LoopArea"
1("1")
2("3")
subgraph "\n\n\nnext"
3("2")
end
subgraph "\n\n\ncur"
4("4")
end
subgraph "\n\n\nbefore"
6("7")
end
end
subgraph "HEAD"
5("9")
end
5 --> 6 --> 4 --> 3 --> 2 --> 1
```
При 2ой итерации теперь надо как-то задейстовать узел с 9, вводить новую переменную?! before_before!?
Через переменные `before` `cur` `next` и `after` скорее всего будет удобнее.
