### Hexlet tests and linter status:
[![Actions Status](https://github.com/C0deFixer/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/C0deFixer/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/a53c7ffbb009b6ddd0a5/maintainability)](https://codeclimate.com/github/C0deFixer/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a53c7ffbb009b6ddd0a5/test_coverage)](https://codeclimate.com/github/C0deFixer/java-project-78/test_coverage)

## Data Validation library 
### Allow to validate String, Number and Map data tipes
#### Examples for using
> String verification 
```Java
var v = new Validator();
// verificatons are accumulating, do not replace each other
var stringSchema = v.string().required().minLength(5).contains("hexlet");
stringSchema.isValid("Represent hexlet as outstanding platfrom for java practice"); // true
```
> Number verification 
```Java
var v = new Validator();
// verificatons are accumulating, do not replace each other
var numberSchema = v.number().range(4,10).positive();
numberSchema.isValid(-10); // false
numberSchema.isValid(5); // true
```
> Map schema verification 
```Java
var v = new Validator();
var mapSchema = v.map();

// shape Map allow to describe validation for each object by it's key in map 
Map<String, BaseSchema<Object>> shapeMap = new HashMap<>();

// Lets tune for "firstName" и "age" key properties
// Name should be string , 2 symbol min length and required 
shapeMap.put("firstName", v.string().minLength(2).required());
// age should be older than 18 
shapeMap.put("age", v.number().positive().range(18,100));

// Setting result of tune into `MapSchema` 
mapSchema.shape(shapeMap);

// validation
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("age", "35");
mapSchema.isValid(human1); // true
```

