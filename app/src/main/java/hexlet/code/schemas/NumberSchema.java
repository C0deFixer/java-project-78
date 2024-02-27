package hexlet.code.schemas;

public class NumberSchema<T extends Number> extends BaseSchema<T> {
    public NumberSchema() {
        super();
    }

    public NumberSchema<T> positive() {
        super.addStrategy(x -> x == null || x.intValue() > 0);
        return this;
    }

    public NumberSchema<T> range(T minValue, T maxValue) {
        super.addStrategy(x -> x == null || (x.doubleValue() >= minValue.doubleValue()) && (x.doubleValue() <= maxValue.doubleValue()));
        return this;
    }

}
