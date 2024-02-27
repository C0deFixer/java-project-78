package hexlet.code.schemas;


public class StringSchema<T extends String> extends BaseSchema<T> {
    public StringSchema() {
        super();
    }

    @Override
    public StringSchema<T> required() {
        super.required();
        super.addStrategy(x -> !x.isBlank());
        return this;
    }

    public StringSchema<T> minLength(int minLength) {
        super.addStrategy(x -> x == null || x.length() >= minLength);
        return this;
    }

    public StringSchema<T> contains(String val) {
        super.addStrategy(x -> x == null || x.contains(val));
        return this;
    }

}
