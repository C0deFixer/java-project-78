package hexlet.code.Strategies;

import java.util.Map;

public class RequriedMap implements Strategy {
    public RequriedMap() {
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return false;
        }
        return object instanceof Map<?,?>;
    }
}
