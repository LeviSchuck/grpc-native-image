I ran
```
java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/com.levischuck.grpc/grpc-server/ -jar target/grpc-server-1.0-launcher.jar
```
And then ran a client against it.
`Ctrl+C` and then the appropriate jsons were ready.