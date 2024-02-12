package hexlet.code.Strategies;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Range implements Strategy {
    private final int minValue;
    private final int maxValue;

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return true;
        }
        return object instanceof Integer
                && (Integer) object >= this.minValue
                && (Integer) object <= this.maxValue;
    }
}
