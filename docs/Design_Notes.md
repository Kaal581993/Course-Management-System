# LearnTrack - Design Notes

This document explains some of the key design choices made during the development of the LearnTrack system, focusing on how they align with core software principles.

## 1. Why use ArrayList instead of a simple Array?

For storing the lists of students, courses, and enrollments, `ArrayList` was chosen over a standard Java `Array`. This decision was driven by the need for a flexible data structure.

*   **Dynamic Sizing**: `ArrayList` can automatically grow or shrink as items are added or removed. This is essential for a management system where the number of records is not fixed, avoiding the manual and inefficient process of creating new arrays and copying data.
*   **Convenience**: The `ArrayList` class provides a rich, built-in API for common operations like `add()`, `remove()`, and `find`. Using a simple array would require writing this logic manually, increasing complexity and the risk of bugs (e.g., correctly shifting elements after a removal).
*   **Type Safety**: Using generics (e.g., `ArrayList<Student>`) provides compile-time type safety. This prevents runtime errors by ensuring that only `Student` objects can be added to the student list, a check that is not possible with a simple `Object[]` array.

## 2. Where are static members used and why?

Static members were used intentionally and exclusively in the `IdGenerator` utility class.

*   **Class**: `spring.coding.util.IdGenerator`
*   **Static Members**:
    *   `private static int studentIdCounter;`
    *   `public static int getNextStudentId()`

*   **Reasoning (Single Global State)**:
    The purpose of an ID counter is to provide a single, unique, and sequential number for each entity across the entire application. This counter is a global state.
    - By making the counter variable (`studentIdCounter`) `static`, there is only **one copy** of this variable in memory. This guarantees that every new student gets a unique ID. If the counter were an instance variable, each service would have its own counter, leading to duplicate IDs.
    - By making the access method (`getNextStudentId()`) `static`, we can call it directly on the class (`IdGenerator.getNextStudentId()`) without needing to create an object. This is efficient and makes the code's intent clear: we are using a shared, global utility.

## 3. Where is inheritance used and what was gained from it?

Inheritance was used to create a `Person` base class, from which `Student` and `Trainer` are derived.

*   **Base Class**: `Person` (Fields: `id`, `firstName`, `lastName`, `email`)
*   **Derived Classes**: `Student extends Person`, `Trainer extends Person`

*   **What was gained**:
    1.  **Code Reusability (DRY Principle)**: The common fields and validation logic (e.g., name cannot be empty) were defined once in the `Person` class and automatically inherited by `Student` and `Trainer`. This reduces code duplication and centralizes the logic for "person-like" attributes.
    2.  **Polymorphism**: This design allows for polymorphic behavior. While not heavily used in the current UI, it would be possible to have a `List<Person>` that holds both `Student` and `Trainer` objects, and the correct `getDisplayName()` method would be called for each.
    3.  **Logical Structure (Is-A Relationship)**: It creates a clear and logical "is-a" relationship that accurately models the real world. A `Student` *is a* `Person`, and a `Trainer` *is a* `Person`. This makes the code more intuitive and self-documenting.
    4.  **Centralized Validation**: By placing validation logic in the setters of the `Person` class, we guarantee that no object that "is-a" `Person` can ever be created with an invalid name or ID. This makes the entire system more robust.
