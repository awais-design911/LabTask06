# Lab Task 06 — Abstract Data Types (ADT)

**Course:** Software Construction — 5th Semester Software Engineering
**Instructor:** Engr. Rizwan Shah
**University:** University of Engineering and Technology, Abbottabad Campus

## Objective

Implement simple ADTs in Java, use interfaces to define contracts, and apply
abstraction and encapsulation principles.

## What was implemented

| Task | Description | Key files |
|------|-------------|-----------|
| 1. Stack ADT | Array-backed LIFO stack implementing a `Stack<T>` interface. `push(10); push(20); push(30);` then `pop()` returns `30`. | `Stack.java`, `ArrayStack.java` |
| 2. Data Encapsulation | `Student` class with private `id`, `name`, `cgpa` fields and public getters only. Direct field access from outside the class fails to compile, proving encapsulation. | `Student.java` |
| 3. Programming to an Abstraction | A single variable declared as `List<String>` is first assigned an `ArrayList`, then reassigned to a `LinkedList`, with identical client code both times. | `Main.java` (see `taskThree_ProgrammingToAbstraction`) |
| 4. Library System ADT | `LibrarySystem` interface (the contract: add/remove/search/issue/return a book) implemented by `LibraryImplementation`, backed by a `HashMap<String, Book>`. | `LibrarySystem.java`, `Book.java`, `LibraryImplementation.java` |
| 5. Student Management System | `StudentCollection` interface (add/remove/find/size/isEmpty) implemented by `StudentCollectionImpl`, backed by an `ArrayList<Student>`. | `StudentCollection.java`, `StudentCollectionImpl.java` |

Every task separates the **specification** (an interface describing *what*
the ADT does) from the **implementation** (a concrete class describing
*how*), and client code is written against the interface type wherever
possible.

## Project structure

```
lab6-adt/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/lab6/
│   │   ├── Stack.java                  (Task 1 - interface)
│   │   ├── ArrayStack.java             (Task 1 - implementation)
│   │   ├── Student.java                (Task 2)
│   │   ├── Book.java                   (Task 4 - data class)
│   │   ├── LibrarySystem.java          (Task 4 - interface)
│   │   ├── LibraryImplementation.java  (Task 4 - implementation)
│   │   ├── StudentCollection.java      (Task 5 - interface)
│   │   ├── StudentCollectionImpl.java  (Task 5 - implementation)
│   │   └── Main.java                   (demo/console output for Tasks 1-3)
│   └── test/java/com/lab6/
│       ├── ArrayStackTest.java
│       ├── StudentTest.java
│       ├── AbstractionTest.java
│       ├── LibraryImplementationTest.java
│       └── StudentCollectionImplTest.java
```

## How to run the code

This is a standard Maven project using JUnit 5 (Jupiter).

**Prerequisites:** JDK 11+ and Maven installed, with internet access so
Maven can download the JUnit 5 dependency the first time.

### Run the Task 1–3 console demo

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.lab6.Main"
```

Or, without Maven's exec plugin:

```bash
mvn package
java -cp target/lab6-adt-1.0.0.jar com.lab6.Main
```

Expected console output includes:
```
=== Lab Task 1: Stack ADT (ArrayStack) ===
Pushed: 10, 20, 30
pop() returned: 30
Expected 30 -> PASS
...
```

### Run all JUnit tests

```bash
mvn test
```

This runs the test classes for all five tasks (Stack, Student
encapsulation, list abstraction, Library System, and Student Collection)
and prints a summary of passed/failed tests.

## Reflection

Working through these five tasks made the difference between an ADT's
*specification* and its *implementation* concrete rather than abstract.
Defining `Stack`, `LibrarySystem`, and `StudentCollection` as interfaces
first, before writing any concrete code, forced a focus on **what**
operations a client actually needs rather than **how** those operations
happen to be implemented. The clearest illustration was Task 3: reassigning
the same `List<String>` variable from an `ArrayList` to a `LinkedList`
without changing a single line of surrounding client code showed directly
why programming to an interface — not a concrete class — makes code more
flexible and swappable.

The main challenge was resisting the urge to add extra convenience methods
to the interfaces that weren't part of the required contract, since a
larger interface is a larger contract that every implementation and every
client has to honor. Keeping each interface minimal (only the operations
specified in the task) made the concrete implementations (`ArrayStack`,
`LibraryImplementation`, `StudentCollectionImpl`) straightforward to write
and test independently.

A possible improvement for the future would be to make the ADT interfaces
generic where it makes sense (e.g. a generic `Collection<T>`-style
interface instead of a `Student`-specific `StudentCollection`), and to add
more edge-case tests (e.g. concurrent modification, capacity limits) to
harden the implementations further.

## Repository

*(Add the public GitHub repository link here before submitting the PDF
report, at the top of the document, as required by the lab task sheet.)*
