package com.hz.xjd.app.utils;

import de.ruedigermoeller.serialization.FSTObjectInput;
import de.ruedigermoeller.serialization.FSTObjectOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;

/**
 * @Author: maopanpan
 * @Description: FST序列化、FST反序列化封装
 * @Date: 2017/10/12.
 **/
public class FSTSerializableUtil {

    public static byte[] serialize(Object... objects) throws Exception {
        ByteArrayOutputStream out = null;
        FSTObjectOutput fout = null;
        try {
            out = new ByteArrayOutputStream();
            fout = new FSTObjectOutput(out);
            fout.writeObject(objects[0]);
            return out.toByteArray();
        } finally {
            if (fout != null) {
                close(fout);
                close(out);
            }
        }
    }

    public static Object deserialize(Object... objects) throws Exception {
        if (objects == null && objects.length > 0) return null;
        if (objects == null)
            return null;
        FSTObjectInput in = null;
        try {
            in = new FSTObjectInput(new ByteArrayInputStream((byte[]) objects[0]));
            return in.readObject();
        } finally {
            if (in != null)
                close(in);
        }
    }

    static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
