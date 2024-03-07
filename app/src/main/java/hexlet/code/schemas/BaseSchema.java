package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    // key contains name of strategy checking
    protected Map<String, Predicate<T>> strategyMap;
    //canceling all other verifications by default until required is call
    protected boolean required = false;

    BaseSchema() {
        this.strategyMap = new HashMap<>(); //Using LinkedList cause order of Predicate validation may be important
    }

    /**
     * @return In subclasses instance verification has to be added
     */
    public BaseSchema<T> required() {
        this.required = true;
        //strategyMap.put("", val -> val != null);
        return this;
    }

    public BaseSchema<T> addCheck(String strategyName, Predicate<T> strategy) {
        this.strategyMap.put(strategyName, strategy);
        return this;
    }

    /**
     * @param val The value to be verified.
     * @return support only primitive values
     */
    public boolean isValid(T val) {
        if (!this.required) {
            return true;
        }
        if (val == null) {
            return false;
        }
        for (Map.Entry<String, Predicate<T>> strategy : strategyMap.entrySet()) {
            if (!strategy.getValue().test(val)) {
                return false;
            }
        }
        return true;
    }
}
