# Design Notes

## Why ArrayList instead of Array

- **Dynamic sizing** – Arrays have a fixed size and require pre-allocating capacity. `ArrayList` grows automatically as elements are added, which is ideal since we don't know how many students, courses, or enrollments will be created at runtime.
- **Built-in methods** – `ArrayList` provides convenient methods like `add()`, `stream()`, and `filter()` that simplify searching and iterating over collections.
- **No manual index management** – With arrays, we'd need to track the current index and handle resizing manually. `ArrayList` abstracts this away.

## Where Static Members are Used and Why

1. **`IdGenerator`** (`util/IdGenerator.java`) – Uses `static` counters (`studentIdCounter`, `courseIdCounter`, `enrollmentIdCounter`) and `static` methods (`getNextStudentId()`, etc.). IDs must be unique across the entire application regardless of which service instance creates them. Static ensures a single shared counter.

2. **`MenuOptions`** (`constants/MenuOptions.java`) – All fields are `public static final int`. These are application-wide constants that don't belong to any instance — they represent fixed menu values shared everywhere.

3. **`InputValidator.parseMenuOption()`** (`util/InputValidator.java`) – A stateless utility method. It doesn't depend on instance state, so making it static allows calling it without instantiation.

4. **`displayStudentDetails()` / `displayCourseDetails()` / `displayEnrollmentDetails()`** in service classes – These are helper methods that only use their parameters, not instance fields, so they are declared static.

## Where Inheritance is Used and What Was Gained

- **`Person` → `Student` and `Person` → `Trainer`** – The `Person` class holds common fields (`id`, `firstName`, `lastName`, `email`) and their getters/setters. `Student` and `Trainer` extend `Person`.

**What was gained:**
- **Code reuse** – Common fields and methods (like `getId()`, `getFirstName()`, etc.) are written once in `Person` and inherited by all subclasses.
- **Consistency** – All person-type entities share the same base structure, making the codebase predictable and easier to extend.
- **Extensibility** – Adding a new person type (e.g., `Admin`) only requires extending `Person` and adding type-specific fields, without duplicating shared logic.
