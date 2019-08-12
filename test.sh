rm -rf out/JorUnit
javac -d out main/JorUnit/Assert.java main/JorUnit/TestResult.java main/JorUnit/TestSuite.java main/JorUnit/Test.java test/JorUnit/TestPrototype.java
java -classpath out JorUnit.TestPrototype
