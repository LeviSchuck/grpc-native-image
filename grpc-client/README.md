With the server running with the jvm `java -jar ../grpc-server/target/grpc-server-1.0-launcher.jar`

I ran
```
java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/com.levischuck.grpc/grpc-client/ -jar target/grpc-client-1.0-launcher.jar Hello
```

then the appropriate jsons were ready.