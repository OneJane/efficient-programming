package com.onejane.lambda.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:16 2019/10/17 0017
 * @ Description ：演示如何使用流(Source) 与 汇(Sink) 来对文件进行常用操作
 */
public class IOTest {

    @Test
    public void copyFile() throws IOException {
        /**
         * 创建对应的Source 流和 Sink 汇
         */
        CharSource charSource = Files.asCharSource(new File("SourceText.txt"), Charsets.UTF_8);

        CharSink charSink = Files.asCharSink(new File("TargetText.txt"), Charsets.UTF_8);

        /**
         * 拷贝
         */
        charSource.copyTo(charSink);
    }
}
