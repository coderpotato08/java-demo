package com.example.springdemo.TestDemos.TestIOStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class TestNIOCore {
    public static void main(String[] args) {
        // 分配一个CharBuffer容量为8
        CharBuffer cb = CharBuffer.allocate(8);
        System.out.println("初始状态：");
        printBufferState(cb);

        // 向buffer写入3个字符
        cb.put('a').put('b').put('c');
        System.out.println("写入3个字符后的状态：");
        printBufferState(cb);

        // 调用flip()方法，准备读取buffer中的数据，将 position 置 0,limit 的置 3
        cb.flip();
        System.out.println("调用flip()方法后的状态：");
        printBufferState(cb);

        // 读取字符
        while (cb.hasRemaining()) {
            System.out.print(cb.get());
        }

        // 调用clear()方法，清空缓冲区，将 position 的值置为 0，将 limit 的值置为 capacity 的值
        cb.clear();
        System.out.println("调用clear()方法后的状态：");
        printBufferState(cb);

        try {
            nioServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // NIO: 监听 8080 端口的 TCP 服务端（echo server）
    public static void nioServer() throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NIO Server started on port 8080...");

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    SocketChannel client = serverChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected: " + client.getRemoteAddress());
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = client.read(buffer);
                    if (bytesRead == -1) {
                        System.out.println("Client disconnected: " + client.getRemoteAddress());
                        client.close();
                        key.cancel();
                        continue;
                    }
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    String message = new String(data);
                    System.out.println("Received: " + message);
                    client.write(ByteBuffer.wrap(("Server echo: " + message).getBytes()));
                }
            }
        }
    }

    private static void printBufferState(Buffer buffer) {
        System.out.print("capacity: " + buffer.capacity());
        System.out.print(", limit: " + buffer.limit());
        System.out.print(", position: " + buffer.position());
        System.out.print(", mark 开始读取的字符: " + buffer.mark());
        System.out.println("\n");
    }
}
