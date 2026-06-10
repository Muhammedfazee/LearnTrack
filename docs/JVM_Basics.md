# JVM Basics

## What is JDK, JRE, JVM?

- **JDK (Java Development Kit)** – The complete toolkit for developing Java applications. It includes the compiler (`javac`), debugger, and other development tools, plus the JRE. You need this to write and compile Java code.

- **JRE (Java Runtime Environment)** – The environment needed to run Java applications. It includes the JVM and standard libraries (like `java.util`, `java.io`). If you only want to run Java programs (not develop them), the JRE is sufficient.

- **JVM (Java Virtual Machine)** – The engine that actually executes Java bytecode. It reads `.class` files and translates bytecode into machine-specific instructions for your operating system. Each OS has its own JVM implementation.

**Relationship:** JDK ⊃ JRE ⊃ JVM

## What is Bytecode?

Bytecode is the intermediate code produced when you compile a `.java` file using `javac`. It's stored in `.class` files. Bytecode is not human-readable like source code, and it's not machine code specific to any processor. Instead, it's a platform-independent set of instructions that the JVM knows how to interpret and execute.

Example: `javac Main.java` produces `Main.class` (bytecode)

## What Does "Write Once, Run Anywhere" Mean?

When you compile Java source code, it gets converted into bytecode — not into machine code for a specific operating system. This bytecode can run on any device that has a JVM installed, whether it's Windows, macOS, or Linux. You write your code once, compile it once, and the same `.class` files work everywhere.

This is different from languages like C/C++, where you must recompile your code for each target platform. With Java, the JVM acts as a translation layer between your bytecode and the underlying hardware, making your programs truly portable.
