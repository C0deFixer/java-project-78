package hexlet.code.schemas;


public final class StringSchema<T> extends BaseSchema<T> {
    public StringSchema() {
        super();
    }

    //
    @Override
    public StringSchema<T> required() {
        super.required();
        strategyMap.put("requried", x -> x instanceof String && !((String) x).isBlank());
        return this;
    }

    public StringSchema<T> minLength(int minLength) {
        strategyMap.put("minLength", x -> ((String) x).length() >= minLength);
        return this;
    }

    public StringSchema<T> contains(String val) {
        strategyMap.put("contains", x -> ((String) x).contains(val));
        return this;
    }

}
