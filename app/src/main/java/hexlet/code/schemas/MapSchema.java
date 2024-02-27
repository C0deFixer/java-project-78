package hexlet.code.schemas;

import java.util.Map;
import java.util.Map.Entry;

public class MapSchema<T, K extends Map<T, T>> extends BaseSchema<T> {
    private Map<T, BaseSchema<T>> schemas;

    public MapSchema() {
        super();
    }

    @Override
    public BaseSchema<T> required() {
        super.required();
        super.addStrategy(x -> x instanceof Map<?, ?>);
        return this;
    }

    public MapSchema<T, K> sizeof(int val) {
        super.addStrategy(x -> ((K) x).size() >= val);
        return this;
    }

    public void shape(Map<T, BaseSchema<T>> schemas) {
        this.schemas = schemas;
    }

    public boolean isValid(Map<T, T> val) {
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

        for (Entry<T, T> entry : val.entrySet()) {
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
