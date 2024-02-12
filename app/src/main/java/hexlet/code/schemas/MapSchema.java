package hexlet.code.schemas;
import hexlet.code.Strategies.RequriedMap;
import hexlet.code.Strategies.Shape;
import hexlet.code.Strategies.MinLength;

import java.util.Map;

public class MapSchema extends BaseSchema implements Validate {
    public MapSchema() {
        super();
    }
    public MapSchema required() {
        this.strategesList.add(new RequriedMap());
        return this;
    }
    public MapSchema sizeof(int minSize) {
        this.strategesList.add(new MinLength(minSize));
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schemaMap) {
        this.strategesList.add(new Shape(schemaMap));
        return this;
    }
}
