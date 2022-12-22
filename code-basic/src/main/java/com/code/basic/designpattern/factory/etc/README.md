# 工厂模式

## 也被称为

* 简单工厂
* 静态工厂方法

## 含义

在工厂类中提供一个封装的静态工厂方法，用于隐藏对象初始化细节，使客户端代码可以专注于使用，而不用关心类的初始化过程。

## 解释

现实例子

>
> 假设我们有一个需要连接到 SQL Server 的 Web 应用，但现在我们需要切换到连接 Oracle。为了不修改现有代码的情况下做到这一点，我们需要实现简单工厂模式。在这种模式下，可以通过调用一个静态方法来创建与给定数据库的连接。

维基百科

> 工厂类是一个用于创建其他对象的对象 -- 从形式上看，工厂方法是一个用于返回不同原型或类型的函数或方法。

**编程示例**

我们有一个  `Car` 接口，以及实现类 `Ford`, `Ferrari`。

```java
public interface Car {
  String getDescription();
}

public class Ford implements Car {

  static final String DESCRIPTION = "This is Ford.";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}

public class Ferrari implements Car {
   
  static final String DESCRIPTION = "This is Ferrari.";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
```

Enumeration above represents types of cars that we support (`Ford` and `Ferrari`).

以下的枚举用于表示支持的 `Car` 类型（`Ford` 和 `Ferrari`）

```java
public enum CarType {
  
  FORD(Ford::new), 
  FERRARI(Ferrari::new);
  
  private final Supplier<Car> constructor; 
  
  CarType(Supplier<Car> constructor) {
    this.constructor = constructor;
  }
  
  public Supplier<Car> getConstructor() {
    return this.constructor;
  }
}
```
接着我们实现了一个静态方法  `getCar` 用于封装工厂类 `CarsFactory`  创建 `Car` 具体对象实例的细节。

```java
public class CarsFactory {
  
  public static Car getCar(CarType type) {
    return type.getConstructor().get();
  }
}
```

现在我们可以在客户端代码中通过工厂类创建不同类型的 `Car` 对象实例。

```java
var car1 = CarsFactory.getCar(CarType.FORD);
var car2 = CarsFactory.getCar(CarType.FERRARI);
LOGGER.info(car1.getDescription());
LOGGER.info(car2.getDescription());
```

程序输出：

```java
This is Ford.
This is Ferrari.
```

## 类图

![alt text](./factory.png "Factory pattern class diagram")

## 适用场景

在你只关心对象的创建，但不关心如何创建、管理它的时候，请使用简单工厂模式。

**优点**

* 可以把对象创建代码集中在一个地方，避免在代码库存散布 "new" 关键字。
* 可以让代码更加低耦合。它的一些主要优点包括更好的可测试性、更好的可读性、组件可替换性、可拓展性、更好的隔离性。

**缺点**

* 会使代码变得比原来的更加复杂一些。



## 几种工厂模式的区别

- 简单工厂：不能算是真正意义上的设计模式，属于一种封装思想，但可以将客户程序从具体类解耦。
- 工厂方法：使用继承，把对象的创建委托给子类，由子类来实现创建方法，可以看作是抽象工厂模式中只有单一产品的情况。
- 抽象工厂：适用于多组合产品的场景，提供接口用于创建相关或依赖对象的家族，而不需要明确指定具体类。

工厂模式可以帮助我们针对抽象/接口编程，而不是针对具体类编程，在不同的场景下按具体情况来使用。
