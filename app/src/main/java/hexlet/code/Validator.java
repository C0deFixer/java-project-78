package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.Map;


public class Validator {
    public StringSchema<String> string() {
        return new StringSchema<String>();
    }

    public NumberSchema<Number> number() {
        return new NumberSchema<Number>();
    }

    public MapSchema<?, Map<?,?>> map() {
        return new MapSchema<>();
    }

}
