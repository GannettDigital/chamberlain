# Chamberlain (The encrypted password generator)

Generate encrypted password files to be used by sqoop, using sqoop default encryption algorithm.
Optionally, the generated password file can be encrypted with Jaspyt StrongTextEncryptor utility class.

## Arguments
* f (filename): The name of the encrypted password file to be generated. If not set, no file will be generated and encrypted password string will be printed on console.
* p (password): The password string to be encrypted into the new file.
* h (passphrase): The passphrase to be used for password encrypt/decrypt.
* s (salt): The salt to be used for password encrypt/decrypt.
* a (algorithm): The algorithm to be used. Sqoop default encryption algorithm is used by default, setting this argument as "password" makes Chamberlain use StrongTextEncryptor utility class instead.

Only password and salt are mandatory, but since we enforce data security we should always use passphrase + salt for Sqoop passwords.

#### How to call the script
For Sqoop passwords:
````
java -jar encrypter.jar -f password_filename.txt -p my_PassW0rd -h passPhrAse -s s4lt
`````

For normal passwords (using StrongTextEncryptor):
````
java -jar encrypter.jar -f password_filename.txt -p my_PassW0rd -s s4lt -a password
`````