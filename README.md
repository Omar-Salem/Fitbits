# README #

### Requirements ###

* Java 8
* Maven

### How to build and run ###

```
#!bash
mvn clean test package
cd target
java -jar Fitbits-1.0.0.jar <path to file>
```

### Assumptions ###
Input file is relatively small
File is well formatted and UTF8( no non existing orientations, positions are within integer range, no missing lines)