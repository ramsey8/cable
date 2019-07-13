package cn.cyf.common.json;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 序列化工具，将数字转换为日期格式字符串
 */
public class LongToDateSerialize implements ObjectSerializer {
    public LongToDateSerialize() {
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        String dateStr = (new org.joda.time.LocalDateTime(object)).toString("yyyy-MM-dd HH:mm:ss");
        serializer.write(dateStr);
    }
}