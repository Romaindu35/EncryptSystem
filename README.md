# EncryptSystem
# Dev by Romaindu35
Encrypt System simplifies the creation of a system of obfuscation of your code.

# How to use it

To use it you just have to create a new EnscryptBuilder object, build it, then run it.
See this example below

```
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setkeys(new Keys("Yourkeys"));
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```
