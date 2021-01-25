![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

[![Build Status](https://github.com/fh-erfurt/Java1-Locster/workflows/build/badge.svg)](https://github.com/fh-erfurt/Java1-Locster/actions)

###### Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers

## Soziales Netzwerk mit Kniff
Im Rahmen des Java1 Projektes haben wir uns mit dem grundlegenden Klassenaufbau sowie der Umsetzung verschiedener Funktionen unseres sozialen Netzwerkes beschäftigt. Zudem haben wir uns mit den Arbeitsabläufen und der Organisation unseres Codes auseinandergesetzt. <br>
<br>
<details>
<summary>Projekt allgemein</summary><br>

HIER FEHLT NOCH EIN EINLEITUNGSTEXT

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
      enum exampleFlag
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
    
    private exmpleFlag example = exampleFlag.value1;
     
<br>

</details>

<details>
<summary>Workflow</summary>
	
## Workflow
Wie klone ich ein Projekt?
1. github.com link kopieren
2. intellij -> fil -> new -> "Project from Version Control..."
3. link in URL einfügen (gegebenenfalls einloggen)
4. wenn ordner nicht bunt dann (rechtsklick pom.xml -> add maven)

Wie wird gearbeitet?

1. assign issues in github.com
2. create branch in github.com (kurzel + issue_name z.B. mga-klasse-message-anlegen)
3. (gegebenfalls erst Projekt klonen)
4. git fetch (in itellij -> VCS -> Project Update)
5. (ggf. Merge -> OK)
6. in intellij unten links auf 9: Git klicken -> rechtklick auf die branch im remote -> Checkout
7. create class(wichtig file name = klassen name z.B. Test)
8. create Testclass(wichtig file name = klassen name + test z.B. MessageTest)

Wie Push ich meinen Code
1. VCS -> Commit -> Änderungen die übernommen werden sollen auswählen -> issue nummer auf github.com herausfinden -> nummer in Commitmessage einfügen + englische message hinzufügen
2. Commit 
3. Push !!! branches überprüfen !!!
4. Creat pull request
5. Assignees hinzufügen
</details>

### Projektpräsentation
Link zur Präsentation

</details>

<details>
<summary>Diagramme</summary><br>

LINK ZU SCREENSHOT ZU KLASSENDIAGRAMM

VERSCHIEDENE UML DIAGRAMME MIT ERKLÄRUNG
</details>

<details>
<summary>Verwendete Technolgie</summary><br>

* Software Dev
   * [Java SDK 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)
   * [IntelliJ IDEA](https://www.jetbrains.com/idea/)
   * [Maven](https://maven.apache.org/)
   * [JUnit](https://junit.org/junit5/)
 
* Diagramme
   * [Lucidchart](https://www.lucidchart.com)
   * [miro](https://miro.com/)
 
* Kommunikation/Worflow
   * [Github](https://github.com/)
   * [Discord](https://discord.com/)
	
</details>
<details>
<summary>Ausblick Java2</summary><br>
Für das kommende Semester haben wir uns folgende Ziele gesetzt:
    * Datenbank
    * Frontend
</details>

