# Password-Generator-and-Encryptor 

This is a program that generates passwords based on the desired conditions and saves them in a notepad encryped. It then allows you to decrypt the passwords and creates a new file that will be deleted in 30 seconds, containing all the passwords.


## How to use

For now it dont have an interface (im working on it). so you have to donwload all the files and run the PasswordManagerApp.java in the gui package.

This screen will show in the console.
```
Welcome to Password Manager APP
Please Select an option:
1. Generate a Password
2. Decrypt Passwords
3. Exit
```

## How it work to generate the password 

The program start asking for the password access that is "teste"
```	private static final String ACCESS_PASSWORD = "teste"; ```
Then it will ask how many digits you want in your new password.
``` Type the size of the password you want: ```
After that it will ask four question. 
* INCLUDE UPPER CASE ? (S/N)
* INCLUDE LOWER CASE ? (S/N)
* INCLUDE NUMBERS ? (S/N)
* INCLUDE SPECIAL CHARACTERS ? (S/N)

Now it will generate your password show to you and ask for a description 
```
Password Generate: b0xVEh
DESCRIPTION FOR THE PASSWORD:
```
Now you will type something like **Facebook Password** and i will ask for the path where you created an .txt or .csv file. 
``` D:\Program Files\password.csv ``` This is what you gonna type - The path and the file name **password.csv**


`PASSWORD SAVED`
Now if you go to this file all the passwords that you created are gonna be crypted.
![image](https://github.com/DaviJonck/Password-Generator-and-Encryptor/assets/17154364/d5fcab82-6cb8-44c8-b7d2-3cf6e6493ba9)


## How it work to decrypt the passwords 
** FIRST YOU NEED TO CHANGE IN THE CLASS PasswordDecryptor IN THE LINE 39 TO WHERE YOU WANT TO SAVE THE DECRYPTED PASSWORDS **
`File outputFile = new File("C:\\Users\\davij\\OneDrive\\decrypted_password.csv");` 

The program will ask for the password to start
```private static final String ACCESS_PASSWORD= "decryptPasswords";```
After you type decryptPasswords the program will start.
Now you have to write the path where the file with the passwords is:
```D:\Program Files\password.csv```

After that it will show all the passwords decrypted in this file and create an new file called **decrypted_password.csv**
This file will be deleted in 30 seconds for your safe.


<sub>Autor: Davi Faustino Jonck </sub>
<sub>Última atualização: 05/19/2023</sub>

