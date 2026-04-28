package com.example.springdemo.TestDemos.TestIOStream;

// NIO 中的文件目录监听服务使用到了观察者模式
import java.nio.file.*;

public class TestFileWatcher {
    public static void main(String[] args) {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            // 初始化一个被监控文件夹的 Path 类
            Path path = Paths.get("/Users/a1234/Desktop/java/spring-demo/src/main/resources/static");
            // 将这个 path 对象注册到 WatchService（监控服务） 中去
            WatchKey watchKey = path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            while ((watchKey = watchService.take()) != null) {
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    // 可以调用 WatchEvent 对象的方法做一些事情比如输出事件的具体上下文信息
                    System.out.println("监听到文件[" + event.context() + "]发生变化 变化类型[" + event.kind() + "]" );
                }
                watchKey.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
