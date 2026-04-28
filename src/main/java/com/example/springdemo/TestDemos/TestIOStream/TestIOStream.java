package com.example.springdemo.TestDemos.TestIOStream;

import java.io.*;

public class TestIOStream {
    private static final String filePath = "/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/analyse-data_read.json";
    private static final String filePath2 = "/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/analyse-data_write.json";
    private static final String outputFilePath = "/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/write.txt";


    public static void readFileWithByte() throws IOException {
        // 字节流
        InputStream fileStream = new FileInputStream(filePath);
        System.out.println("Number of remaining bytes:" + fileStream.available());
        long skip = fileStream.skip(10);
        System.out.println("The actual number of bytes skipped:" + skip);
        System.out.print("The content read from file:");
        byte[] buffer = new byte[1024];
        int bytesRead, loop = 0;
        while ((bytesRead = fileStream.read(buffer, 0, buffer.length)) != -1 && loop < 20) {
            System.out.println(new String(buffer, 0, bytesRead));
            System.out.println("----------");
            loop ++;
        }
    }

    // BufferedOutputStream BufferedInputStream 字节缓冲流
    public static void readFileWithBuffer() throws IOException {
        BufferedInputStream bs = new BufferedInputStream(new FileInputStream(filePath));
        String result = new String(bs.readAllBytes());
        System.out.println(result);
    }

    public static void writeFile() throws IOException {
        FileOutputStream os = new FileOutputStream(outputFilePath);
        DataOutputStream ds = new DataOutputStream(os);
        // byte[] arr = "JavaGuide".getBytes();
        // os.write(arr);
        ds.writeBoolean(true);
        ds.writeByte(1);
    }

    /*
    * 字符流
    * Reader Writer
     */
    public static void runFileReader() throws IOException {
        FileReader fileReader = new FileReader(outputFilePath);
        int content;
        long skip = fileReader.skip(3);
        System.out.println("The actual number of characters skipped:" + skip);
        System.out.print("The content read from file:");
        while ((content = fileReader.read()) != -1) {
            System.out.print((char) content);
        }
    }

    public static void copy_json_with_buffer_stream() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath2));
        int content;
        while ((content = bis.read()) != -1) {
            bos.write(content);
        }
        System.out.println("使用缓冲流复制JSON文件总耗时:" + (System.currentTimeMillis() - start) + "毫秒");
    }

    public static void copy_json_with_stream() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath2);
        int content;
        while ((content = fis.read()) != -1) {
            fos.write(content);
        }
        System.out.println("使用普通流复制JSON文件总耗时:" + (System.currentTimeMillis() - start) + "毫秒");
    }

    /*
    * 随机访问流
    * */
    public static void randomAccessFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File(outputFilePath), "rw");
        System.out.println("读取之前的偏移量：" + raf.getFilePointer() + "，读取内容：" + (char) raf.read() + "读取之后的偏移量" + raf.getFilePointer());
        raf.seek(6);
        System.out.println("读取之前的偏移量：" + raf.getFilePointer() + "，读取内容：" + (char) raf.read() + "读取之后的偏移量" + raf.getFilePointer());

        // 从偏移量 7 的位置开始往后写入字节数据
        raf.write(new byte[]{'H', 'I', 'J', 'K'});
        System.out.println("写入之后的内容长度：" + raf.length());
    }

    public static void main(String[] args) {
        try {
//            readFileWithByte();
//            readFileWithBuffer();
//            writeFile();
//            runFileReader();
//            copy_json_with_buffer_stream();
//            copy_json_with_stream();
            randomAccessFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}