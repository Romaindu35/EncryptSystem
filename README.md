[version]: https://img.shields.io/maven-central/v/com.github.romaindu35/enscryptsystem.svg?label=Download
[download]: https://search.maven.org/search?q=g:%22com.github.romaindu35%22%20AND%20a:%22enscryptsystem%22

# EncryptSystem
### Dev by Romaindu35
Encrypt System simplifies the creation of a system of obfuscation of your code.

# How to download it ?

To download it you have 2 choices: compile the library or use a buildTool as a gradle.

Latest version :

[ ![version][] ][download]

### Use with gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.github.romaindu35:enscryptsystem:VERSION'
}
```

### Use with maven

```xml
<dependencies>
    <dependency>
      <groupId>com.github.romaindu35</groupId>
      <artifactId>enscryptsystem</artifactId>
      <version>VERSION</version>
    </dependency>
</dependencies>
```

# How to use it

To use it you just have to create a new EnscryptBuilder object, build it, then run it.
See this example below

```java
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setkeys(new Keys("Yourkeys"));
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```
If you want to convert files in a directory, you can use the ScanDir

Basic example :
```java
ScanDirBuilder scanDirBuilder = new ScanDirBuilder(true);
ScanDir scanDir = scanDirBuilder.build();
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setKeys(new Keys("Yourkeys")).setScanDir(scanDir);
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```

The ScanDir have a particularity, we can filter files to convert :
If you want to keep only files with .zip extension, you can use this code :
```java
ScanDirBuilder scanDirBuilder = new ScanDirBuilder(true).addFilterList(new Filter().extensionUse(".zip"));
ScanDir scanDir = scanDirBuilder.build();
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setKeys(new Keys("Yourkeys")).setScanDir(scanDir);
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```
With the ScanDir you can also convert files in other extension :
If you want to convert files with extension .zip to file with extension .aes, you can use this code:
```java
ScanDirBuilder scanDirBuilder = new ScanDirBuilder(true).addFilterList(new Filter().extensionUse(".zip")).convertTo(".aes");
ScanDir scanDir = scanDirBuilder.build();
EncryptBuilder encryptBuilder = new EncryptBuilder(imputFiles, outputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setKeys(new Keys("Yourkeys")).setScanDir(scanDir);
Encrypt encrypt = encryptBuilder.build();
encrypt.launch();
```

Do you want the generated file to be deleted after closing the program ? With EncryptMemory you can do it !
```java
EncryptMemoryBuilder encryptMemoryBuilder = new EncryptMemoryBuilder(imputFiles).setCipherMod(CipherMod.ENCRYPT_MODE).setkeys(new Keys("Yourkeys"));
EncryptMemory encryptMemory = encryptMemoryBuilder.build();
File file = encryptMemory.loadInMemory(); // loadInMemory return file after input file crypt/decrypt
```

# Notes

This library is open source, licensed Apache-2.0 License.
If you have any comments, please let me know.
You can contact me on Discord with the nickname: romaindu35#5770