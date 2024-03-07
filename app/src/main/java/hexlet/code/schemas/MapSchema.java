package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<R, T> extends BaseSchema<T> {

    public MapSchema() {
        super();
    }

    @Override
    public BaseSchema<T> required() {
        //public BaseSchema<Map<T, R>> required() {
        super.required();
        //addCheck("requied", x -> x instanceof Map<?, ?>);
        return this;
    }

    public MapSchema<R, T> sizeof(int val) {
        //addCheck("sizeOff", x -> ((Map) x).size() >= val);
        addCheck("sizeOff", x -> ((Map) x).size() >= val);
        return this;
    }

    public MapSchema<R, T> shape(Map<String, BaseSchema<T>> schemas) {
        addCheck(
                "shape",
                map -> {
                    return schemas.entrySet().stream().allMatch(e -> {
                        var v = ((Map) map).get(e.getKey());
                        var schema = e.getValue();
                        return schema.isValid((T) v);
                    });
                }
        );
        return this;
    }

/*    public boolean isValid(Map<R, T> val) {
        if (!super.isValid((T) val)) {
            return false;
        }
        for (int i = 0; i < super.strategyMap.size(); i++) {
            if (!strategyMap.get(i).test((T) val)) {
                return false;
            }
        }
        if (schemas == null) {
            return true;
        }

        for (Entry<R, T> entry : val.entrySet()) {
            if (schemas.containsKey(entry.getKey())) {
                BaseSchema<T> currentSchema = schemas.get(entry.getKey());
                T currentValue = entry.getValue();
                if (!currentSchema.isValid(currentValue)) {
                    return false;
                }
            }
        }
        return true;
    }*/
}
