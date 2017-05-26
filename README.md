# Pipeline [![Build Status](https://travis-ci.org/damonkelley/pipeline.svg?branch=master)](https://travis-ci.org/damonkelley/pipeline)

The `Pipeline` is an attempt to bring the pipe operation from bash and many functional programming languages to Java.
The `Pipeline` leverages functional interfaces and generics to allow one to pipe the output of a method as input
to another method in a readable way.

##### Example
```java
class MyClass {
    public MyClass withoutPipeline() {
        return baz(bar(foo(this)));
    }

    MyClass foo(MyClass myClass) {...}

    MyClass foo(MyClass myClass) {...}

    MyClass foo(MyClass myClass) {...}
}
```


##### With `Pipeline`
```java
class MyClass {
    public MyClass withPipeline() {
        return Pipeline.with(1)
            .into(this::foo)
            .into(this::bar)
            .into(this::baz)
            .get();
    }
    // ...
}
```
