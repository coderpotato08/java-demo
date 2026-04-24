# Java业务常用类渐进式学习方案

基于实际业务开发中最常用的类，按从易到难设计6个阶段，每阶段约2周。

---

## 阶段一：基础语法与核心类（第1-2周）

**学习目标**：掌握最常用的基础类，能写出简单的程序。

学习顺序：
1. **String（字符串）**
   - 创建、拼接、比较（equals vs ==）
   - 常用方法：substring、indexOf、split、trim、length、contains
   - 理解不可变性

2. **StringBuilder**
   - 为什么用它（循环拼接性能好）
   - append、insert、toString

3. **ArrayList（动态数组）**
   - add、remove、get、size、遍历
   - 与普通数组的区别

4. **Arrays工具类**
   - sort排序、toString打印、asList转List

5. **Math工具类**
   - abs、max、min、random、pow

**练习项目**：简易学生管理系统——添加、删除、显示学生列表，用ArrayList存储。

---

## 阶段二：集合框架（第3-4周）

**学习目标**：理解不同集合的特点，能根据场景选择合适的集合。

学习顺序：
1. **HashMap（最重要）**
   - put、get、remove、containsKey
   - 三种遍历方式（keySet、entrySet、values）

2. **HashSet**
   - 去重原理（equals和hashCode）
   - 与List的区别

3. **LinkedList**
   - 头尾操作快，中间查找慢
   - 与ArrayList对比

4. **LinkedHashMap**
   - 保持插入顺序的Map

5. **Collections工具类**
   - sort、reverse、shuffle、max、min

**练习项目**：通讯录系统——姓名查电话（HashMap），记录去重（HashSet）。

---

## 阶段三：异常处理与工具类（第5-6周）

**学习目标**：学会处理程序错误，使用常用工具类。

学习顺序：
1. **异常处理体系**
   - try-catch-finally
   - throw与throws区别
   - NullPointerException、IllegalArgumentException
   - 自定义异常

2. **Objects工具类**
   - equals（空安全）、requireNonNull

3. **BigDecimal（金额必用）**
   - 避免double精度丢失问题
   - add、subtract、multiply、divide
   - setScale舍入模式

4. **UUID**
   - randomUUID生成唯一标识

5. **Enum枚举**
   - 定义常量（替代final static）
   - 枚举的属性和方法

**练习项目**：精确计算器——处理输入异常，用BigDecimal做加减乘除。

---

## 阶段四：现代Java特性（第7-8周）

**学习目标**：掌握Java 8+核心特性，写出简洁优雅的代码。

学习顺序：
1. **Optional**
   - of、ofNullable、isPresent
   - orElse、orElseThrow返回默认值或抛异常

2. **Stream流**
   - filter、map、sorted、distinct
   - collect转集合、forEach遍历
   - 流式链式操作

3. **LocalDateTime系列**
   - LocalDate（日期）、LocalTime（时间）、LocalDateTime（日期时间）
   - now、parse、format
   - plusDays、minusHours、Duration
   - 替代旧的Date和Calendar

4. **函数式接口**
   - Function<T,R>、Predicate、Consumer
   - Lambda表达式简化代码

**练习项目**：用户数据处理——用Stream过滤、排序、分组一个用户列表。

---

## 阶段五：并发与IO（第9-10周）

**学习目标**：初步了解多线程和文件操作。

学习顺序：
1. **基础线程**
   - Thread与Runnable
   - start vs run
   - sleep、join

2. **线程池入门**
   - Executors.newFixedThreadPool
   - submit提交任务
   - shutdown

3. **CompletableFuture**
   - supplyAsync异步执行
   - thenApply、thenAccept链式调用
   - 异常处理 exceptionally

4. **AtomicInteger**
   - 原子递增，替代synchronized

5. **文件操作（Files）**
   - readString、writeString（Java 11+）
   - readAllLines按行读取
   - copy、delete、exists
   - Path路径表示

6. **BufferedReader/BufferedWriter**
   - 按行读写大文件

**练习项目**：日志分析器——异步读取多个日志文件，统计关键词出现次数。

---

## 阶段六：综合应用（第11-12周）

**学习目标**：了解企业开发常用库和项目结构。

学习顺序：
1. **JSON处理**
   - Jackson：ObjectMapper的readValue、writeValueAsString
   - 对象与JSON互转

2. **JSON处理（Gson备选）**
   - fromJson、toJson

3. **反射基础**
   - Class.forName获取类
   - getMethod、invoke（浅尝则止）

4. **Lombok**
   - @Data、@Getter/@Setter
   - @Builder、@AllArgsConstructor

5. **Spring Boot概念**
   - Controller、Service、Repository分层
   - 依赖注入概念
   - @RestController、@Autowired

**练习项目**：RESTful API入门——用Spring Boot返回JSON数据，实现增删改查。

---

## 学习建议

1. **每学3-4个方法就写小程序验证**，不要只看不练。
2. **先掌握最常用的**，不常用的遇到再查API。
3. **每个阶段至少完成1个练习项目**。
4. **多看报错信息**，学会根据异常定位问题。

---

## 每阶段核心类速查

| 阶段 | 必须掌握 | 了解即可 |
|------|---------|---------|
| 一 | String、ArrayList、Arrays | StringBuilder、Math |
| 二 | HashMap、HashSet | LinkedList、LinkedHashMap |
| 三 | 异常处理、BigDecimal | Objects、UUID、Enum |
| 四 | Stream、Optional、LocalDateTime | Function、Predicate |
| 五 | Thread、CompletableFuture、Files | 线程池、AtomicInteger |
| 六 | Jackson/Gson | 反射、Lombok、Spring概念 |
