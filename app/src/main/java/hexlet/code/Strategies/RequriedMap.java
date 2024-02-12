package hexlet.code.Strategies;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class RequriedMap implements Strategy {

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return false;
        }
        return object instanceof Map<?, ?>;
    }
}
