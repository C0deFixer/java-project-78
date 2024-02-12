package hexlet.code.Strategies;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public class Shape implements Strategy {
    private Map<String, BaseSchema> schemaMap;
    public Shape(Map<String, BaseSchema> schemaMap) {
        this.schemaMap = schemaMap;
    }

    @Override
    public boolean match(Object object) {
        var result = this.schemaMap.entrySet().stream()
                .filter(x -> !x.getValue().isValid(((Map) object).get((x.getKey()))))
                .toList();
        return result.isEmpty();
    }
}
