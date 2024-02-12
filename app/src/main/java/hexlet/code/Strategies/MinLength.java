package hexlet.code.Strategies;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class MinLength implements Strategy {
    private final int minLength;

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String && ((String) object).length() >= minLength) {
            return true;
        } else if (object instanceof Map<?, ?> && ((Map) object).size() >= minLength) {
            return true;
        }
        return false;
    }
}
