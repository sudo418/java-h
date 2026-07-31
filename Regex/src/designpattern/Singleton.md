# Singleton Design Pattern

## Definition

> **Singleton Design Pattern** ensures that only one object (instance)
> of a class is created throughout the application and provides a global
> access point to that object.

------------------------------------------------------------------------

# Why do we use Singleton?

We use Singleton when creating multiple objects can: - Waste memory or
resources. - Cause inconsistency in data. - Create conflicts while
accessing a shared resource.

Examples: - Database Connection - Logger - Configuration Manager - Cache
Manager - Printer Spooler - Thread Pool Manager

------------------------------------------------------------------------

# Key Points

-   Constructor is **private** so objects cannot be created from outside
    the class.
-   A **private static** variable stores the only object.
-   A **public static** method (`getInstance()`) returns that object.

------------------------------------------------------------------------

# 1. Eager Initialization

``` java
private static DatabaseConnection db = new DatabaseConnection();
```

The object is created immediately when the class is loaded.

Flow:

``` text
Class Loaded
      │
      ▼
Object Created
      │
      ▼
getInstance()
      │
      ▼
Returns Same Object
```

Advantages: - Simple - Thread-safe by default - No synchronization
required

Disadvantages: - Object is created even if never used.

------------------------------------------------------------------------

# 2. Lazy Initialization

``` java
private static Logger log;

public static Logger getLog() {
    if (log == null) {
        log = new Logger();
    }
    return log;
}
```

Initially:

``` text
log = null
```

First call:

``` text
getLog()
   │
   ▼
log == null ?
   │
  Yes
   │
Create Object
   │
Store in log
   │
Return Object
```

Second call:

``` text
getLog()
   │
   ▼
log == null ?
   │
  No
   │
Return Existing Object
```

The `if` statement ensures the object is created only once.

Without the `if`, every call would create a new object, breaking the
Singleton pattern.

------------------------------------------------------------------------

# Eager vs Lazy

Feature           Eager                      Lazy
  ----------------- -------------------------- --------------------------------------
Object Creation   During class loading       On first request
Uses `if`         No                         Yes
Memory            May create unused object   Saves memory
Thread Safety     Yes                        Basic version is **not** thread-safe

------------------------------------------------------------------------

# Why is the constructor private?

``` java
private Logger() { }
```

This prevents:

``` java
new Logger(); // Compile-time Error
```

Objects can only be created from inside the class.

------------------------------------------------------------------------

# Why is getInstance() static?

Initially no object exists, so we cannot call an instance method.

A static method can be called directly:

``` java
Logger log = Logger.getLog();
```

------------------------------------------------------------------------

# Important Interview Point

The basic Lazy Singleton is **not thread-safe**.

If two threads execute `getLog()` simultaneously:

``` text
Thread-1 -> log == null -> Yes
Thread-2 -> log == null -> Yes

Both create a Logger object.
```

Result:

``` text
Thread-1 -> Logger Object 1
Thread-2 -> Logger Object 2
```

This breaks the Singleton rule.

Thread-safe solutions (learn after multithreading): - synchronized -
Double-Checked Locking - Bill Pugh Singleton - Enum Singleton

------------------------------------------------------------------------

# Interview Definition

> Singleton ensures only one instance of a class exists and provides a
> global access point to that instance.

------------------------------------------------------------------------

# Revision Summary

-   One object only.
-   Private constructor.
-   Private static instance variable.
-   Public static accessor method.
-   Eager = object created during class loading.
-   Lazy = object created on first use.
-   Basic Lazy Singleton is not thread-safe.
