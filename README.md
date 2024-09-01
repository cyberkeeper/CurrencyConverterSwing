
# Currency Converter Java Swing

This is a simple currency converter application for demonstrating Java Swing,  the application was created in IntelliJ UI Designer. 

Although not required for the course this code makes uses of a resource bundle to demonstrate how all displayed text strings could be contained in a single place. Keeping all string in a single places makes maintenance a bit easier. It also allows internalisation to be included, this example includes English and Spanish text. By default English text will be shown, to test Spanish find the following lines in the runProgram method in the Main.java file.

```
Locale whereAmI = Locale.getDefault();
//Locale whereAmI = Locale.forLanguageTag("es");
```

Comment out the 'getDefault' line and enable the 'es' line to switch to Spanish.

## Authors

- [@cyberkeeper](https://github.com/cyberkeeper)


## Screenshots

![screenshot](https://github.com/cyberkeeper/CurrencyConverterGUI/assets/40637121/6596407f-2277-4919-b326-64a6c0b86af8)

## Requirements
Microsoft Windows 10 or Windows 11
Java SDK 18, 20 or 22

## Deployment
-Download the CurrencyConverter.zip file
-Extract the file to c:\currency

If the files are deployed to another location update 'runApp.bat' and 'currency converter.lnk' to reflect the new location.

## Running
-Double click the Currency Converter.lnk file.

## FAQ

### How do I run the application?

To run the application download all the files in the release. Method 1 worked on Windows 10 Pro but generated an error on Windows 11 Pro. If you receive a "Java Exception has occurred" message when double clicking the JAR file. Use method 2.

1. Simplest way to run is by double clicking the JAR file.
2. Double click the Currency Convert.lnk file


The Currency Converter application has been tested on Microsoft Windows 10 Pro and Microsoft Windows 11 Pro.
The program has been tested with the following SDKs,
- Java 18 
- Java 20
- Java 22


### Could this application be improved?

Yes, it has been kept simple to illustrate the basic structure of the program. It could be extended but how the currencies and demonstration currency exchange rates are included would need to updated for ease of use.

### Does this need to be compiled in IntelliJ

Yes, the project makes use of the IntelliJ Java UI Designer.
