package hexlet.code.schemas;

import hexlet.code.Strategies.Positive;
import hexlet.code.Strategies.Range;
import hexlet.code.Strategies.RequriedNumber;
import hexlet.code.Validator;

public class NumberSchema extends BaseSchema implements Validate {

    public NumberSchema(Validator validator) {
        super(validator);
    }

    public NumberSchema required() {
        strategesList.add(new RequriedNumber());
        return this;
    }

    public NumberSchema positive() {
        strategesList.add(new Positive());
        return this;
    }

    public NumberSchema range(int min, int max) {
        strategesList.add(new Range(min, max));
        return this;
    }
}
