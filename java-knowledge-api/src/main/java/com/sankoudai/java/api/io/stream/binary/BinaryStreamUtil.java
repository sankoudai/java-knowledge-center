package com.sankoudai.java.api.io.stream.binary;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : sankoudai
 * @version : created at 2015/10/28
 */
public class BinaryStreamUtil {

    /**
     * 从流中读取字节到指定数组
     * @param in    字节流
     * @param bytes 目标数组
     * @param offset 数组的起始位置（用于存放字节）
     * @param bytesToRead 读取的最大字节数
     * @return 实际读取的字节数. 到达文件尾部时实际读取的字节数少于bytesToRead
     */
    public int reliableRead(InputStream in, byte[] bytes, int offset, int bytesToRead) throws IOException {
        int bytesRead = 0;

        int start = offset;
        while (bytesRead < bytesToRead){
            int fetched = in.read(bytes, start, bytesToRead - bytesRead);
            if(fetched == -1){//文件结尾
                break;
            }

            bytesRead += fetched;
            start += fetched;
        }
        return bytesRead;
    }
}
