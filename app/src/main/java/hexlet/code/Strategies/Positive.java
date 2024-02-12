package hexlet.code.Strategies;

public class Positive implements Strategy {
    public Positive() {
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof Integer) {
            return (Integer) object > 0;
        }
        return false;
    }

}
