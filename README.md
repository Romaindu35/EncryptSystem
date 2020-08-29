# EncryptSystem
# Dev by Romaindu35
Encrypt System simplifies the creation of a system of obfuscation of your code.

# How to download it ?

To download it you have 2 choices: compile the library or use a buildTool as a gradle.

# Use with gradle

```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Romaindu35:EnscryptSystem:TAG'
}
```

# How to use it

To use it you just have to create a new EnscryptBuilder object, build it, then run it.
See this example below

```
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setkeys(new Keys("Yourkeys"));
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```
