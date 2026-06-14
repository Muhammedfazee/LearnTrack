# Setup Instructions

## JDK Version

This project uses **JDK 8** (or higher). Any version from JDK 8 onwards is compatible.

To check your installed version:

```bash
java -version
javac -version
```

## Running a Hello World Program

A simple way to verify your setup is working:

1. Create a file `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

2. Compile it:

```bash
javac HelloWorld.java
```

This produces a `HelloWorld.class` file (bytecode).

3. Run it:

```bash
java HelloWorld
```

**Expected output:**

```
Hello, World!
```

If you see this output, your JDK is correctly installed and configured.

## Running LearnTrack

```bash
cd LearnTrack
javac -d out -sourcepath src src/com/airtribe/learntrack/ui/Main.java
java -cp out com.airtribe.learntrack.ui.Main
```

You should see the main menu appear in the console.
