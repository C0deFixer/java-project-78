package hexlet.code.Strategies;
import org.apache.commons.lang3.StringUtils;

public class Contains implements Strategy {
    private String stringContains;
    public Contains(String stringContains) {
        this.stringContains = stringContains;
    }
    @Override
    public boolean match(Object string) {
        return StringUtils.contains((String) string, stringContains);
    }

}
