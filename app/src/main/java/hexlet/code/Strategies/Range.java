package hexlet.code.Strategies;

public class Range implements Strategy {
    private int minValue;
    private int maxValue;

    public Range(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Integer
                && (Integer) object >= this.minValue
                && (Integer) object <= this.maxValue) {
            return true;
        } else {
            return false;
        }
    }
}
