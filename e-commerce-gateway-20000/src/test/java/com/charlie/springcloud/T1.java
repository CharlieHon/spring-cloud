package com.charlie.springcloud;

import java.util.function.Function;

public class T1 {
    public static void main(String[] args) {
        // 传入的第二个参数是一个lambda表达式，实现了函数式接口Function<String, Cat>，
        //  即需要实现其中的apply方法，接收一个String类型并返回一个Cat类型
        // lambda表达式的第一种形式
        // Dog dog1 = hi("WangCai", (String str) -> {
        //    Cat cat = new Cat();
        //    cat.setName(str);
        //    return cat;
        //});

        // 形式2：
        //Dog dog2 = hi("WangCai", str -> {
        //    Cat cat = new Cat();
        //    cat.setName(str);
        //    return cat;
        //});

        // 形式3
        //Dog dog = hi("WangCai", str -> {
        //    return new Cat(str);
        //});

        // 形式4
        Dog dog = hi("WangCai", str -> new Cat(str));

        System.out.println(dog);  // Dog{name='WangCai~狗'}
    }

    /*
        public Builder route(String id, Function<PredicateSpec, Route.AsyncBuilder> fn) {
            Route.AsyncBuilder routeBuilder = (Route.AsyncBuilder)fn.apply((new RouteSpec(this)).id(id));
            this.add(routeBuilder);
            return this;
        }

        routes.route("member_route04", r -> r.path("/member/get/**")
                .uri("http://localhost:10010"))
     */

    // 模拟把Cat -> Dog
    public static Dog hi(String str, Function<String, Cat> fn) {
        Cat cat = fn.apply(str);
        Dog dog = new Dog();
        dog.setName(cat.getName() + "~狗");
        return dog;
    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat {
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
