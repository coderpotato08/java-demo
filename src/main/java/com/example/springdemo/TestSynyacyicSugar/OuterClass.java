package com.example.springdemo.TestSynyacyicSugar;

public class OuterClass {
    private String name;
    private Integer age;

    class InnerClass {
        private Object data;

        public String printOuterName() {
            System.out.println(name);
            return name;
        }
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
