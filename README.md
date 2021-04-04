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

----

This demonstrates creating a schema, a server, and a client with GRPC in java.
Further, this project succeeds in showing how to make a native-image with graalvm for the client and server.
My findings are that:

1. It does start faster (like 0.04s), compared to the JVM with 1.1s
2. The binary size is usually between 25-35MB for small things (which I find mildly unreasonable considering I live the C life sometimes)
3. It takes about 6 GB of RAM to compile this small project for each artifact. (That's absurd)
4. But, when it comes down to like server vs client, the JVM is faster after it warms up (this takes a long time). How much faster? like 1.5-2x assuming there's no IO besides localhost networking
5. So compiled uses like 30-35 MB of RAM, while JVM uses 205MB of resident RAM

So at 14% of the memory and 27x startup time, it does seem warranted to use this for lambdas and sidecars
But for primary (externally facing) services that run for hours, and are not nanosecond realtime, the JVM is advised.
