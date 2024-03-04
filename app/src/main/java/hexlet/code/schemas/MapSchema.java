package hexlet.code.schemas;

import java.util.Map;
import java.util.Map.Entry;

public final class MapSchema<R, T> extends BaseSchema<T> {
    //public class MapSchema<T, R> extends BaseSchema<Map<T, R>> {
    private Map<R, BaseSchema<T>> schemas;
    //private Map<T, BaseSchema<Map<T,R>>> schemas;

    public MapSchema() {
        super();
    }

    @Override
    public BaseSchema<T> required() {
        //public BaseSchema<Map<T, R>> required() {
        super.required();
        strategyList.add(1, x -> x instanceof Map<?, ?>);
        return this;
    }

    public MapSchema<R, T> sizeof(int val) {
        strategyList.add(x -> ((Map) x).size() >= val);
        return this;
    }

    public void shape(Map<R, BaseSchema<T>> schemasMap) {
        this.schemas = schemasMap;
    }

    public boolean isValid(Map<R, T> val) {
        if (!super.isValid((T) val)) {
            return false;
        }
        for (int i = 0; i < super.strategyList.size(); i++) {
            if (!strategyList.get(i).test((T) val)) {
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
    }
}
