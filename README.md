![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

[![Build Status](https://github.com/fh-erfurt/Java1-Locster/workflows/build/badge.svg)](https://github.com/fh-erfurt/Java1-Locster/actions)

###### Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers

## Soziales Netzwerk mit Kniff
Im Rahmen des Java1 Projektes haben wir uns mit dem grundlegenden Klassenaufbau sowie der Umsetzung verschiedener Funktionen unseres sozialen Netzwerkes beschäftigt. Zudem haben wir uns mit den Arbeitsabläufen und der Organisation unseres Codes auseinandergesetzt. <br>
<br>
<details>
<summary>Projekt allgemein</summary><br>

HIER FEHLT NOCH EIN EINLEITUNGSTEXT <br>
Das projekt ist eine sozialmedie app bzw seite, wo man mit menschen kommentzieren könnte, eine regiestierung ist erfordlich dann könnte man nachrichten an freundne schicken bzw. freundschaft anfrage und man dürfte seite profiel jederzeit bearbeiten. besonders ist, man kann sein profil statstik anschauen und dort werden angezeigt , welche letzte 10 User hat man besucht bzw. welche 10 User haben sein profil besuchet. etc ...

### Projektteam
Das Team vom Locster besteht aus:
* **Dirk Hofmann** - [Profil](https://github.com/Munchkin129)
* **Jakob Gensel** - [Profil](https://github.com/bro-scientist)
* **Matthias Gabel** - [Profil](https://github.com/f0rkster)
* **Molham Al-Khodari** - [Profil](https://github.com/Molham321)
* **Saskia Wohlers** - [Profil](https://github.com/schnoernja)

<details>
<summary>Codestyle</summary>
<h2>Codestyle</h2>
<br>
1. Sprache<br>
<br>
<ul>
<li>Code und Kommentare werden in englisch verfasst.</li>
</ul>
<br>
2. Klassen<br>
<br>
<ul>
	<li>Klassen werden in der Ordnerstrukter unter <strong>src/main...</strong> angelegt.</li>
	<li>Klassenname sowie Dateiname werden in <strong>UpperCamelCase</strong> geschrieben</li>
<li>Beispiel: ClassName.java</li>
<li>Die Strukturierungen der Klassen sehen wie folgt:</li>
</ul>

 <br>
 
    1. Konstanten und Klassenvariablen 
    2. Enum
    3. Variablen
    4. Konstruktor
    5. abstrakte Methoden
    6. Methoden
    7. Getter & Setter
    
 - Die Sektionen werden jeweilig mit folgendem Kommentar initiiert:
<br>
 
    /*
    ===================================
    == Sektionsname
    ===================================
    */

<br>
3. Methoden<br>
<br>
<ul>
	<li>Methodennamen werden in <strong>lowerCamelCase</strong> geschrieben</li>
<li>Beispiel: methodName</li>
</ul>

 
<br>
4. Variablen<br>
<br>
<ul>
	<li>Variablen werden in <strong>lowerCamelCase</strong> geschrieben</li>
<li>Beispiel: variablenName</li>
	<li>Der Gültigkeitsbereich der Variablen wird standartgemäß als <strong>private</strong> deklariert.<br>
		Innerhalb der Klasse wird auf die Variablen mit <strong>this.</strong> zugegriffen.<br>
		Außerhalb der Klasse wird dann folglich mit <strong>Settern & Gettern</strong> auf die Variablen zugegriffen.<br>
		Anhand der <strong>Settern & Gettern</strong> erkennt man somit auch die Zugriffsrechte.<br>
Mit einem triftigen Grund kann von der Regelung abgewichen werden.</li>
</ul>
<br>
5. Kommentar<br>
<br>
<ul>
<li>Am Anfang einer jeder Datei hinterlässt der Bearbeiter eine Signatur die wie folgt aussieht.</li>
</ul>
<br>
 
    /*
    ===================================
    == Max Mustermann
    ===================================
    */

<br>
<ul>
	<li>Methoden und Klassen werden über den Bezeichner kommentiert und wie folgt initiiert</li>
 </ul>
<br>

    Allgemeines Beispiel
    /**
     *Comment
     * @param argument explanation what the argument do
     * @return explanation what the method do
     */
     
    Konkretes Beispiel
    /**
     * Marks a messsage as read by the reading user and returns the message text.
     * @param reader user, who is reading the message
     * @return the text the message contains
     */
     
<br>
die IDE IntelliJ sollte hier den Anwender unterstützen.
<br>
6. Tests<br>
<br>
<ul>
	<li>Klassen werden in der Ordnerstrukter unter <strong>src/main...</strong> angelegt.</li>
	<li>Test sowie Dateiname werden in <strong>UpperCamelCase</strong> geschrieben und enden mit dem Suffix "Test"</li>
<li>Beispiel: ClassNameTest.java</li>
	<li>Die Tests sollen einen aussagekräftigne Bezeichner erhalten und sind wie folgt aufgebaut</li>
</ul>
<br>
 
    @Test
    void exact_explanation_what_the_test_should_do()
    {
        // Given
	int example1 = 0;
	// When
	int result = example1.succ();
	// Then
	assertEquals(1, result);
    }

<br>
7. Enum<br>
<br>
<ul>
<li>enums bekommen den Suffix "Flag"</li>
	<li>werden allerdings als Variable ohne Suffix initiiert.</li>
	<li>Folgendes Beispiel sollte Klarheit verschaffen</li>
</ul>
<br>

    /*
    ===================================
    == ENUM
    ===================================
    */
      enum Example
      {
             value1,
             value2,
             value3
      }
    /*
    ===================================
    == VARIABLE
    ===================================
    */
    
    private Exmple example = Example.value1;
     
<br>

</details>

<details>
<summary>Workflow</summary>
	
## Workflow

Wie wird gearbeitet?

1. Teambesprechung zu nötigen Änderungen jede Woche Donnerstag (ggf. öfter)
2. Issue zu Bug/Feature erstellen
3. Aufgabe/Issue zuweisen
4. Branch erstellen
5. Issue bearbeiten
6. Tests erstellen/bzw. anpassen
7. Branch pushen & Pull Request
8. Branch mergen & löschen

</details>

### Projektpräsentation
Link zur Präsentation

</details>

<details>
<summary>Diagramme</summary><br>
	
## Klassendiagramm <br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![Klassendiagramm](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/klassendiagramm.png) <br>


<details>
<summary>chat package</summary><br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![chat](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/chat.png) <br>

</details>

<details>
<summary>friend package</summary><br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![friend](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/friend.png) <br>

</details>

<details>
<summary>guestbook package</summary><br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![guestbook](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/guestbook.png) <br>

</details>

<details>
<summary>user package</summary><br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![user1](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user1.png) <br>
![user2](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user2.png) <br>

</details>

<details>
<summary>Exceptions & ValidationUtility package</summary><br>
	
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
	
![rest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/exceptions%26validation.png) <br>

</details>
	
### Aktivitätsdiagramme

<details>
<summary>Register User</summary><br>

![registerUser](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/registerUser.png) <br>
![check](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/check.png) <br>
![isValidEmail](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/isValidEmail.png) <br>
![isValidPassword](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/isValidPassword%26Username.png) <br>
	
</details>
<hr>
</details>


<details>
<summary>Verwendete Technolgien</summary>

* Entwicklertools
   <br>
   <a id="intellij-logo" href="https://www.jetbrains.com/idea/"><img src="https://daviddelatorre.me/wp-content/uploads/2017/06/intellij.png" height=40></a>
   <br>
   <a id="maven-logo" href="https://maven.apache.org/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Maven_logo.svg/512px-Maven_logo.svg.png" height=40>	    </a>
   <br>
   <a id="junit-logo" href="https://junit.org/junit5/"><img src="https://junit.org/junit4/images/junit5-banner.png" height=40></a>
   
   
* Diagramme
   <br>
   <a id="lucidchart-logo" href="https://www.lucidchart.com"><img src="http://www.sbmarketingtools.com/wp-content/uploads/2016/04/lucidchart-logo.png" height=40></a>
   <br>
   <a id="miro-logo" href="https://miro.com/"><img src="https://www.underconsideration.com/brandnew/archives/miro_logo.png" height=40></a>
 
* Kommunikation
   <br>
   <a id="discord-logo" href="https://discord.com/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Discord_Color_Text_Logo.svg/640px-Discord_Color_Text_Logo.svg.png" height=40></a>
	
</details>
<details>
<summary>Ausblick Java2</summary>

* Für das kommende Semester haben wir uns bereits folgende Ziele gesetzt:
    * **Datenbank für die Speicherung der Nutzerdaten**
    * **Nutzeroberfläche/Webseite**

</details>

