# Chamberlain (The encrypted password generator)

Generate encrypted password files to be used by sqoop, using sqoop default encryption algorithm.

## Arguments
* The name of the encrypted password file to be generated.
* The password string to be encrypted into the new file.
* The passphrase to be used for password encrypt/decrypt.
* The salt to be used for password encrypt/decrypt.

All arguments are mandatory, since we enforce data security and we should always use passphrase + salt for Sqoop to decrypt

#### How to call the script
````
java -jar encrypter.jar password_filename.txt my_PassW0rd passPhrAse s4lt
`````
