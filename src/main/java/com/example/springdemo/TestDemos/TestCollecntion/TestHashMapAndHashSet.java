package com.example.springdemo.TestDemos.TestCollecntion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AddressBook {
    private String name;
    private Integer age;
    private String mobile;

    public AddressBook (String name, Integer age, String mobile) {
        this.age = age;
        this.name = name;
        this.mobile = mobile;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
public class TestHashMapAndHashSet {
    public static void main(String[] args) {
        Set<AddressBook> addressBookSet = new HashSet<>();
        AddressBook xiaoMing = new AddressBook("小明", 18, "18918023112");
        addressBookSet.add(xiaoMing);
        addressBookSet.add(xiaoMing);
        addressBookSet.add(new AddressBook("小王", 30, "13711234124"));
        addressBookSet.add(new AddressBook("小牛", 23, "13723524234"));
        addressBookSet.add(new AddressBook("小白", 48, "18923552211"));

        System.out.println("通讯录长度: " + addressBookSet.size());
        System.out.println("----------");
        List<String> mobiles = addressBookSet.stream().map(AddressBook::getMobile).toList();
        System.out.println("通讯录所有号码: ");
        for(String mobile: mobiles) {
            System.out.println(mobile);
        }
        System.out.println("----------");
        List<String> filterMobiles = addressBookSet
                .stream()
                .map(AddressBook::getMobile)
                .filter(m -> m.startsWith("189"))
                .toList();
        System.out.println("通讯录所有电信号码: ");
        for(String mobile: filterMobiles) {
            System.out.println(mobile);
        }
    }
}
