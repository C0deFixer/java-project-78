package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.Map;


public class Validator<R, T> {
    public StringSchema<?> string() {
        return new StringSchema<String>();
    }

    public NumberSchema<?> number() {
        return new NumberSchema<Number>();
    }

    public MapSchema<R, Map<R, T>> map() {
        return new MapSchema<R, Map<R, T>>();
    }

}
