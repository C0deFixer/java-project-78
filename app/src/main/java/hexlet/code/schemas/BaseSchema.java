package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    List<Predicate<T>> strategyList;
    boolean required = false; //canceling all other verifications by default until required is call

    BaseSchema() {
        this.strategyList = new LinkedList<>(); //Using LinkedList cause order of Predicate validation may be important
    }

    public boolean isValid(T val) {
        if (!this.required) {
            return true;
        }
/*        return strategyList.stream()
                .filter(strategy-> strategy.test(val))
                .toList()
                .isEmpty();*/
        //for debug
        for (int i = 0; i < strategyList.size(); i++) {
            if (!strategyList.get(i).test(val)) {
                return false;
            }
        }
        return true;
    }

    /**
     @return In subclasses instance verification has to be added
     */
    public BaseSchema<T> required() {
        this.required = true;
        //index 0 null check always first
        strategyList.add(0, val -> val != null);
        return this;
    }

}
