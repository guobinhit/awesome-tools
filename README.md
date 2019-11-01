# awesome-tools

![author](https://img.shields.io/badge/author-chariesgavin-blueviolet.svg)![last commit](https://img.shields.io/github/last-commit/guobinhit/awesome-tools.svg)![issues](https://img.shields.io/github/issues/guobinhit/awesome-tools.svg)![stars](https://img.shields.io/github/stars/guobinhit/awesome-tools.svg)![forks](	https://img.shields.io/github/forks/guobinhit/awesome-tools.svg)![license](https://img.shields.io/github/license/guobinhit/awesome-tools.svg)

Some awesome tools.

## INDEX

- [Monitor](#monitor)
- [Sequence](#sequence)
- [Page Info](#page-info)
- [Date Time](#date-time)

## Monitor

Using `MonitorWaterLineCalculator` class, we can calculate monitor water line, for example `TP95` :

```java
// create a calculator with water line 95
MonitorWaterLineCalculator calculator = new MonitorWaterLineCalculator(95);
// call calculate method to calculate value
calculator.calculate(param);
// call getResult method to get calculate result
calculator.getResult();
```

## Sequence

Using `FlowNoGenerator` class, we can get a unique flow sequence, for example :

```java
String uniqueNo = FlowNoGenerator.generate("SC");
```

or 

```java
String uniqueNo = FlowNoGenerator.generate("SC", "BIC");
```

as above, `generate` method have two signatures:

- `generate(String sysCode)`

- `generate(String sysCode, String bizCode)`

The first parameter is `sysCode` means system code, the second parameter is `bizCode` means business code.

If we only pass a parameter, it's stand by `sysCode`, and `bizCode` will be set `000` as a default value. 

## Page Info

Using `PageHelper<T>` class, we can divide page, for example：

```java
List<String> paramList = new ArrayList<String>();
PageHelper<String> pageHelper = new PageHelper<String>(paramList);
List<String> dividePageResultList = pageHelper.getList();
```

or 

```java
List<String> paramList = new ArrayList<String>();
PageHelper<String> pageHelper = new PageHelper<String>(1, 10, paramList);
List<String> dividePageResultList = pageHelper.getList();
```

as above, `PageHelper` class have two construction method :

- `PageHelper(List<T> list)`

- `PageHelper(int pageNum, int pageSize, List<T> list)`

The first construction method will call the second construction method :

- `pageNum` : the number of page
- `pageSize` : the capacity of per page 
- `list` : the data list that we want to divide page

 If we instance `PageHelper` with the only parameter of `list`, the default value of  `pageNum`  is `1` and `pageSize` is `10`.

## Date Time Util

Using `ThreadSafeDateUtil` class, we can get thread safe date time method.
