package hexlet.code.schemas;

public final class NumberSchema<T> extends BaseSchema<T> {
    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema<T> required() {
        super.required();
        //index 1 -> should be next after null check
        strategyMap.put("requried", x -> x instanceof Number);
        return this;
    }

    public NumberSchema<T> positive() {
        strategyMap.put("positive", x -> ((Number) x).intValue() > 0);
        return this;
    }

    public NumberSchema<?> range(int minValue, int maxValue) {
        strategyMap.put("range", x ->
                (((Number) x).doubleValue() >= minValue)
                        && (((Number) x).doubleValue() <= maxValue));
        return this;
    }

}
