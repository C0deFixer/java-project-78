package hexlet.code.schemas;


public final class StringSchema<T> extends BaseSchema<T> {
    public StringSchema() {
        super();
    }

    //
    @Override
    public StringSchema<T> required() {
        super.required();
        strategyList.add(1, x -> x instanceof String && !((String) x).isBlank());
        return this;
    }

    public StringSchema<T> minLength(int minLength) {
        strategyList.add(x -> ((String) x).length() >= minLength);
        return this;
    }

    public StringSchema<T> contains(String val) {
        strategyList.add(x -> ((String) x).contains(val));
        return this;
    }

}
