This project needs [sdkman](https://sdkman.io/usage)!

You will need to install sdkman, then 
```shell
sdk env
```

if you see errors then 
```shell
sdk install java 21.0.0.2.r11-grl
sdk install maven
gu install native-image
```

_Note: `gu` is the [graalvm updater](https://www.graalvm.org/reference-manual/graalvm-updater/)_

Note that graalvm only supports up to java 11 right now
So in IntelliJ set the language level to 11.


This project comes with `native-image` as part of the maven build process.
```shell
mvn clean package
```
should result in some binaries in the target folders.

