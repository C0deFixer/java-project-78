package hexlet.code.schemas;

import hexlet.code.Strategies.Contains;
import hexlet.code.Strategies.RequriedString;
import hexlet.code.Strategies.MinLength;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StringSchema extends BaseSchema {


    public StringSchema required() {
        this.strategesList.add(new RequriedString());
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.strategesList.add(new MinLength(minLength));
        return this;
    }

    public StringSchema contains(String string) {
        this.strategesList.add(new Contains(string));
        return this;
    }


}
