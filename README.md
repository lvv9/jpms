TODO: legacy packages in module path or class path

when run by IntelliJ IDEA(Application.class), these packages/classes will be included in module path:
- unoinpay\target\classes
- spring-web-6.2.6.jar
- spi-interface\target\classes
- spring-boot-autoconfigure-3.4.5.jar
- application\target\classes
- spring-boot-3.4.5.jar

packaging:
see packaging\pom.xml

running:
```shell
PATH\TO\JAVA\bin\java.exe -cp packaging\target\lib\* -p packaging\target\modules -m application/me.liuweiqiang.application.Application
PATH/TO/JAVA/bin/java -cp "packaging/target/lib/*" -p packaging/target/modules --add-modules entity_new -m application/me.liuweiqiang.application.controller.HelloWorldController
PATH/TO/JAVA/bin/java -p "packaging/target/lib:packaging/target/modules/artifact-application-1.0-SNAPSHOT.jar:packaging/target/modules/artifact-spi-interface-1.0-SNAPSHOT.jar:packaging/target/modules/artifact-unoinpay-1.0-SNAPSHOT.jar:packaging/target/modules/spring-boot-3.4.5.jar:packaging/target/modules/spring-boot-autoconfigure-3.4.5.jar:packaging/target/modules/spring-web-6.2.6.jar:packaging/target/modules/artifact-entity-automatic-1.0-SNAPSHOT.jar" --add-modules ALL-MODULE-PATH -m application/me.liuweiqiang.application.Application
```

```
--class-path classpath, -classpath classpath, or -cp classpath
Specifies a list of directories, JAR files, and ZIP archives to search for class files.

On Windows, semicolons (;) separate entities in this list; on other platforms it is a colon (:).

Specifying classpath overrides any setting of the CLASSPATH environment variable. If the class path option isn't used and classpath isn't set, then the user class path consists of the current directory (.).

As a special convenience, a class path element that contains a base name of an asterisk (*) is considered equivalent to specifying a list of all the files in the directory with the extension .jar or .JAR . A Java program can't tell the difference between the two invocations. For example, if the directory mydir contains a.jar and b.JAR, then the class path element mydir/* is expanded to A.jar:b.JAR, except that the order of JAR files is unspecified. All .jar files in the specified directory, even hidden ones, are included in the list. A class path entry consisting of an asterisk (*) expands to a list of all the jar files in the current directory. The CLASSPATH environment variable, where defined, is similarly expanded. Any class path wildcard expansion that occurs before the Java VM is started. Java programs never see wildcards that aren't expanded except by querying the environment, such as by calling System.getenv("CLASSPATH").

--module-path modulepath... or -p modulepath
Specifies where to find application modules with a list of path elements. The elements of a module path can be a file path to a module or a directory containing modules. Each module is either a modular JAR or an exploded-module directory.

On Windows, semicolons (;) separate path elements in this list; on other platforms it is a colon (:).
```

https://docs.oracle.com/javase/specs/jls/se9/html/jls-7.html#jls-7.7
https://openjdk.org/projects/jigsaw/spec/sotms/
https://docs.oracle.com/en/java/javase/21/docs/specs/man/java.html