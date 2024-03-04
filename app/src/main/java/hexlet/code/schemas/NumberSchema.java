package hexlet.code.schemas;

public class NumberSchema<T> extends BaseSchema<T> {
    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema<T> required() {
        super.required();
        //index 1 -> should be next after null check
        strategyList.add(1, x -> x instanceof Number);
        return this;
    }

    public NumberSchema<T> positive() {
        strategyList.add(x -> ((Number) x).intValue() > 0);
        return this;
    }

    public NumberSchema<?> range(Number minValue, Number maxValue) {
        strategyList.add(x ->
                (((Number) x).doubleValue() >= minValue.doubleValue())
                        && (((Number) x).doubleValue() <= maxValue.doubleValue()));
        return this;
    }

}
