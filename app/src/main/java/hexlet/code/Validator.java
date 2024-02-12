package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

public class Validator {

    public StringSchema string() {
        return new StringSchema(this);
    }

    public NumberSchema number() {
        return new NumberSchema(this);
    }
    public MapSchema map() {
        return new MapSchema(this);
    }

}
