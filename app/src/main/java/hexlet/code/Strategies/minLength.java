package hexlet.code.Strategies;

import java.util.Map;

public class minLength implements Strategy {
    private int minLength;

    public minLength(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String && ((String) object).length() >= minLength) {
            return true;
        }
        if (object instanceof Map<?,?> && ((Map) object).size() >= minLength) {
            return true;
        }
        return false;
    }
}
