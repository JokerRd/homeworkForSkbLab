package ru.skblab.controller.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataSerializer extends StdSerializer<Date> {

    private static final SimpleDateFormat formatter
            = new SimpleDateFormat("yyyy-MM-dd");

    protected DataSerializer(Class<Date> t) {
        super(t);
    }

    protected DataSerializer(JavaType type) {
        super(type);
    }

    protected DataSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    protected DataSerializer(StdSerializer<?> src) {
        super(src);
    }

    public DataSerializer(){
        this(Date.class);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(formatter.format(value));
    }
}
