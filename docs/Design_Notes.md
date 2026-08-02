# LearnTrack - Design Notes

This document explains some of the key design choices made during the development of the LearnTrack system.

## 1. Why use ArrayList instead of a simple Array?

For storing the lists of students, courses, and enrollments, `ArrayList` was chosen over a standard Java `Array` for several important reasons:

*   **Dynamic Size**: `ArrayList` can dynamically grow or shrink in size. When we add a new student, we don't have to worry about creating a new, larger array and copying all the elements over. The `ArrayList` handles this automatically. This is essential for an application where the number of records is unknown and changes frequently.
*   **Ease of Use**: The `ArrayList` class provides a rich set of methods for common operations, such as `add()`, `remove()`, `get()`, and `isEmpty()`. Performing these same operations on a simple array would require writing more complex and error-prone manual code (e.g., finding an element and then shifting all subsequent elements to fill the gap after a removal).
*   **Generics**: `ArrayList<Student>` provides type safety. The compiler ensures that only `Student` objects can be added to the list, preventing runtime errors that could occur if we accidentally tried to add a `Course` to the student list.

## 2. Where are static members used and why?

Static members were used intentionally in the `IdGenerator` utility class.

*   **Class**: `spring.coding.util.IdGenerator`
*   **Static Members**:
    *   `private static int studentIdCounter;`
    *   `private static int courseIdCounter;`
    *   `public static int getNextStudentId()`
    *   `public static int getNextCourseId()`

*   **Reasoning**:
    The purpose of an ID counter is to provide a single, unique, and sequential number across the entire application. It represents a global state that should not be tied to any specific instance of a class.
    - By making the counter variable (`studentIdCounter`) `static`, there is only **one copy** of this variable in memory for the entire application, regardless of how many times we might (incorrectly) instantiate `IdGenerator`.
    - By making the access method (`getNextStudentId()`) `static`, we can call it directly on the class (`IdGenerator.getNextStudentId()`) without needing to create an object instance first. This is efficient and makes the code clearer about its intent: we are requesting a global utility, not performing an operation on a specific object.

## 3. Where is inheritance used and what was gained from it?

Inheritance was used to create a `Person` base class and have `Student` and `Trainer` extend it.

*   **Base Class**: `Person` (Fields: `id`, `firstName`, `lastName`, `email`)
*   **Derived Classes**: `Student extends Person`, `Trainer extends Person`

*   **What was gained**:
    1.  **Code Reusability**: The common fields and methods (`id`, `firstName`, `lastName`, `getDisplayName()`) did not have to be rewritten in both the `Student` and `Trainer` classes. They were defined once in `Person` and inherited automatically. This reduces code duplication and makes maintenance easier.
    2.  **Polymorphism**: While not heavily used in this simple console app, it sets the stage for polymorphic behavior. For example, you could have a `List<Person>` that holds both `Student` and `Trainer` objects. When you call `getDisplayName()` on an element in the list, the JVM would automatically execute the correct version of the method (the one from `Student` or the one from `Trainer`).
    3.  **Logical Structure (Is-A Relationship)**: It creates a clear and logical "is-a" relationship in the object model. A `Student` *is a* `Person`. A `Trainer` *is a* `Person`. This makes the code more intuitive and easier to understand for other developers.
