# decrypt-master-password

Small tool to decrypt passwords which are generated by `mvn --encrypt-master-password` and stored in
`settings-security.xml` (see documentation about [Password Encryption] in maven). You can see the relevant piece of code for encryption [here][code for encryption]

```
$ mvn --encrypt-master-password foo
{p/4zbBy9DFQHPpMPvz3tgwBf1tbXqDYFFbDzkMFTAtE=}
```

```
$ mvn --quiet exec:java <<< '{p/4zbBy9DFQHPpMPvz3tgwBf1tbXqDYFFbDzkMFTAtE=}'
Encrypted password:
Decrypted password: foo
```

[Password Encryption]: https://maven.apache.org/guides/mini/guide-encryption.html
[code for encryption]: https://github.com/apache/maven/blob/maven-3.2.5/maven-embedder/src/main/java/org/apache/maven/cli/MavenCli.java#L515-L518
