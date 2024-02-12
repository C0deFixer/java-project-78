package hexlet.code.schemas;

import hexlet.code.Strategies.Positive;
import hexlet.code.Strategies.Range;
import hexlet.code.Strategies.RequriedNumber;

public class NumberSchema extends BaseSchema implements Validate {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        //strategesList.add(new RequriedNumber());
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
