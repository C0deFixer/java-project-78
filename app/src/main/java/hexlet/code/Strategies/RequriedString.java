package hexlet.code.Strategies;

import java.util.Map;

public class RequriedString implements Strategy {
    public RequriedString() {
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return false;
        }
        return object instanceof String && !((String) object).isEmpty();
    }
}
