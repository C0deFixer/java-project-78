package hexlet.code.schemas;

import hexlet.code.Strategies.Strategy;
import hexlet.code.Validator;
import java.util.ArrayList;
import java.util.List;

//Implements Validate for universal Client call isValid method

public class BaseSchema implements Validate {
    protected List<Strategy> strategesList;
    private final Validator validator;

    BaseSchema(Validator validator) {
        this.validator = validator;
        this.strategesList = new ArrayList<>();
    }

    public boolean isValid(Object value) {
       // Using List of Strategies which does.nt fit/match value (wrong meaning) ;
        List<Strategy> result = this.strategesList.stream()
                .filter(strategy -> !strategy.match(value))
                .toList();
        return result.isEmpty();
    }
}
