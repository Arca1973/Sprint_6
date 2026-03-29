# Sprint 6 — Unit-тесты для Java-проекта

## Описание

Проект содержит unit-тесты для классов `Animal`, `Feline`, `Cat` и `Lion` из пакета `com.example`.
Тесты написаны с использованием **JUnit 4** и **Mockito**, а покрытие кода проверяется через **JaCoCo**.

## Стек технологий

- **Java 11**
- **Maven**
- **JUnit 4.13.1**
- **Mockito 3.12.4**
- **JaCoCo 0.8.7**

## Структура проекта

```text
src/
├── main/java/com/example/
│   ├── Animal.java
│   ├── Predator.java
│   ├── Feline.java
│   ├── Cat.java
│   └── Lion.java
└── test/java/com/example/
    ├── CatTests.java
    ├── FelineTests.java
    ├── LionTests.java
    ├── ParameterizedCatTest.java
    └── ParameterizedLionTest.java
```

## Что покрыто тестами

### `Cat`
- проверка звука (`getSound()` → `"Мяу"`)
- проверка получения еды через мок `Feline` (`getFood()`)
- параметризованный тест для разных наборов еды

### `Feline`
- `eatMeat()`
- `getFamily()`
- `getKittens()` (по умолчанию)
- `getKittens(int kittensCount)`

### `Lion`
- проверка гривы для самца/самки (`doesHaveMane()`)
- проверка количества котят (`getKittens()`)
- проверка исключения при некорректном поле
- проверка получения еды (`getFood()`)
- параметризованные тесты для пола и признака гривы

## Покрытие (JaCoCo)

Отчёт формируется в папке:

```text
target/site/jacoco/index.html
```

Текущее покрытие по отчёту:
- **Instructions:** 88%
- **Branches:** 75%

Покрытие по классам:
- `Cat` — 100%
- `Feline` — 100%
- `Lion` — 100%
- `Animal` — частично (не полностью покрыты ветки `getFood(...)`, метод `getFamily()` не покрыт)

## Как запустить

### Запуск тестов

```bash
mvn clean test
```

### Запуск тестов с генерацией отчёта JaCoCo

```bash
mvn verify
```

После выполнения открой файл `target/site/jacoco/index.html` в браузере.
