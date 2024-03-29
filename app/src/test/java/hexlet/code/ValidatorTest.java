package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @DisplayName("String schema test")
    @Test
    void stringTest() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        assertThat(schema.isValid(null)).isTrue(); // true
        assertThat(schema.isValid("")).isTrue(); // true


        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid("")).isFalse(); // false
        assertThat(schema.isValid(5)).isFalse(); // false
        assertThat(schema.isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.isValid("hexlet")).isTrue(); // true

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse(); // false

        assertThat(schema.isValid("what does the fox say")).isFalse(); // false
    }

    @Test
    void numberTest() {
        Validator v = new Validator();

        NumberSchema schema = v.number();

// Пока не вызван метод required(), null считается валидным
        assertThat(schema.isValid(null)).isTrue(); // true
        assertThat(schema.positive().isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid("5")).isFalse(); // false
        assertThat(schema.isValid(10)).isTrue(); // true

// Потому что ранее мы вызвали метод positive()
        assertThat(schema.isValid(-10)).isFalse(); // false
//  Ноль — не положительное число
        assertThat(schema.isValid(0)).isFalse(); // false

        schema.range(5, 10);

        assertThat(schema.isValid(5)).isTrue(); // true
        assertThat(schema.isValid(10)).isTrue(); // true
        assertThat(schema.isValid(4)).isFalse(); // false
        assertThat(schema.isValid(11)).isFalse(); // false
    }

    @Test
    void mapValidTest() {

        Validator v = new Validator();

        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid(new HashMap<>())).isTrue(); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue(); // true

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();  // false
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue(); // true
    }

    @Test
    void mapShape() {
        Validator v = new Validator();

        MapSchema schema = v.map();

// shape позволяет описывать валидацию для значений каждого ключа объекта Map
// Создаем набор схем для проверки каждого ключа проверяемого объекта
// Для значения каждого ключа - своя схема
        Map<String, BaseSchema<Object>> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "name" и "age"
// Имя должно быть строкой, обязательно для заполнения
        schemas.put("name", v.string().required());
// Возраст должен быть положительным числом, но пока учловие отключено т.к. не вызван метод requried
        schemas.put("age", v.number().positive());

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
        schema.shape(schemas);
        schema.required();

// Проверяем объекты
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue(); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue(); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse(); // false

        //Включаем работу  условия на возвраст
        schemas.get("age").required();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse(); // false

        var codes = new HashMap<String, Integer>();
        codes.put("usa", 1);
        codes.put("france", 33);
        codes.put("germany", 49);
        var entries = codes.entrySet();
        for (var entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
