package hexlet.code.Strategies;

public class RequriedNumber implements Strategy {
    public RequriedNumber() {
    }

    @Override
    public boolean match(Object object) {
        if (object == null) {
            return false;
        }
        return object instanceof Integer;

    }
}
