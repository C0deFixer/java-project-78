package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public List<Predicate<T>> strategyList;

    BaseSchema() {
        this.strategyList = new ArrayList<>();
    }

    public boolean isValid(T val) {
        /*return strategyList.stream()
                .filter(strategy-> strategy.match(val))
                .toList()
                .isEmpty();*/
        for (int i = 0; i < strategyList.size(); i++) {
            if (!strategyList.get(i).test(val)) {
                return false;
            }
        }
        return true;
    }

    public BaseSchema<T> required() {
        strategyList.add(val -> val != null);
        return this;
    }

    protected void addStrategy(Predicate<T> strategy) {
        strategyList.add(strategy);
    }

}
