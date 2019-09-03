package com.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

/**
 * @autor sunyiban
 * @date 2019/9/3 10:22
 * @descrpition
 */
public class PrivateDataSerializer extends StdSerializer<String> implements ContextualSerializer {

    private int start;
    private int end;

    public PrivateDataSerializer() {
        super(String.class);
    }

    private PrivateDataSerializer(int start, int end) {
        super(String.class);
        this.start = start;
        this.end = end;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        Position position = beanProperty.getAnnotation(Position.class);
        return new PrivateDataSerializer(position.start(), position.end());
    }

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String result;
        if (end == -1) {
            result = around(s, start, end);
        } else {
            result = left(s, start);
        }

        jsonGenerator.writeString(result);
    }

    /**
     * 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     *
     * @param fullName
     * @param  index 1 为第index位
     * @return
     */
    private String left(String fullName,int index) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, index);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * [身份证号] 110****58，前面保留3位明文，后面保留2位明文
     *
     * @param name
     * @param index
     * @param end
     * @return
     */
    private String around(String name,int index,int end) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.left(name, index).concat(StringUtils.removeStart(
                StringUtils.leftPad(StringUtils.right(name, end), StringUtils.length(name), "*"), "***"));
    }
}
