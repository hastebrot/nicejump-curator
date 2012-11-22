# Installation under Windows

Download dependencies.

```
C:>cd deps
C:>mvn dependency:copy-dependencies
C:>cd ..
```

Configure paths to OpenJUMP, compile and deploy.

```
C:>set JUMP_HOME=C:\_openjump\openjump-bin-1.4.2\openjump-1.4.2
C:>set JUMP_CORE_JAR=openjump-core-1.4.2-SNAPSHOT.jar
C:>ant deploy
```
