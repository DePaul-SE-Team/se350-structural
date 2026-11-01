# SE350 – Structural Design Patterns

Java examples of the GoF structural patterns for DePaul SE350.

## Patterns

All sources are under `code/src/main/java/org/example/`.

| Pattern   | Examples |
|-----------|----------|
| Adapter   | `RealEstateExample`, `TextFormatter`, `VoltageConverterExample` (class & object adapters), `Simple` |
| Composite | `DrawingAppExample`, `FinancialAppExample`, `KitchenStaffExample`, `Simple` |
| Decorator | `CarExample`, `PrintTextExample`, `PrinterExample`, `guiclass`, `classcode`, `ClassTestCode`, `Simple`, `Simple2` |
| Facade    | `WritingExamFacade` / `DwarvenMineWorker`, `Simple` |
| Flyweight | `Examples`, `Simple` |

Each `Simple` folder contains `Bad/` and `Good/` versions showing the code before and after applying the pattern.

## Build & Run

Requires Java 21 and Maven.

```bash
cd code
mvn compile
```

Run any class with a `main` method (the `*Driver`, `*Client`, or `Main` classes) from your IDE, or:

```bash
mvn exec:java -Dexec.mainClass="org.example.Adapter.VoltageConverterExample.SocketAdapterDriver"
```
