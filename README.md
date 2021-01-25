![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

[![Build Status](https://github.com/fh-erfurt/Java1-Locster/workflows/build/badge.svg)](https://github.com/fh-erfurt/Java1-Locster/actions)

<h6>Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers</h6>

<h2>Soziales Netzwerk mit Biss</h2>
Im Rahmen der Veranstaltung "Java Programmierung 1 & 2" haben wir uns entschlossen, ein soziales Netzwerk mit Schwerpunkt auf chatten und Leute aus der Umgebung kennenzulernen. Ganz ohne nervige Babybilder und Katzenvideos.<br>
<br>
<details>
<summary> Projekt allgemein</summary><br>
<h2>Projektteam</h2>
Das Team vom Locster besteht aus: <br>
<br>
<ul>
<li><strong>Dirk Hofmann</strong> https://github.com/Munchkin129 <br></li>
<li><strong>Jakob Gensel</strong> https://github.com/bro-scientist <br></li>
<li><strong>Matthias Gabel</strong> https://github.com/f0rkster <br></li>
<li><strong>Molham Al-Khodari</strong> https://github.com/Molham321 <br></li>
<li><strong>Saskia Wohlers</strong> https://github.com/schnoernja <br></li>
</ul>
	
### Einführung

In unserem Projekt möchten wir uns mit der Entwicklung eines sozialen Netzwerks beschäftigen. In diesem Netzwerk soll es administrativen Zugriff von der Entwicklerseite aus geben und einen Nutzer Zugriff (de.teamLocster.User.User) . Die Nutzer können sich ihr eigenes Profil nach den individuellen Ansprüchen gestalten. Die Nutzer können selbständige ihre Freundesliste verwalten. Zudem können Sie Nachrichten verschicken und sich gegenseitig Gästebucheinträge schreiben. Jeder Nutzer hat einen eigenen Kalender, in dem er Events finden kann, an denen er teilnimmt. 
Das soziale Netzwerk soll außer dem eigenen Profil auch noch andere Seiten anzeigen können:
<br>
<ul>
<li>eine Seite „News“ - für lokale Nachrichten und Events -</li>
<br>
<li>eine Seite „Wer ist online?“ – für das Anzeigen von Usern in der Umgebung-</li>
<br>
<li>eine Seite „Freunde“ – für das Anzeigen von Usern in der Freundesliste -</li>
<br>
<li>eine Seite „Nachrichten“->für das Einsehen der eigenen Nachrichten-,</li>
<br>
<li>eine Seite „News“ - für lokale Nachrichten und Events -</li>
</ul>
<br>
Jedes Profil beinhaltet ein Profilbild, persönliche Daten (welche man nach eigenem Ermessen angeben kann), ein Gästebuch, einen eigenen „Blog“-Abschnitt, den man nach freiem Wunsch gestalten kann, einen Abschnitt für Fotos, und einen Abschnitt für Statistiken (die letzten Besucher wie oft wurde mein Profil in letzter Zeit besucht, usw.)

<h2>Idee und Produkt</h2>
zum Miroboard für die Ideenfindung: https://miro.com/app/board/o9J_lf2VPJc=/ <br>
<br>
Die Idee zum Locster hatte sich nach mehrmaligem brainstorming über die Plattform <strong>miro</strong> https://miro.com/signup/ aus einer 
Auswahl von z.B. einer WG-Verwaltung, Campus-Navigator und Texteditor durchgesetzt. <br>
Der Grundsatz war, dass jedes uns bekannte soziale Netzwerk vollkommen überlaufen ist von Werbung, unlustigen Posts von der lieben Tante, und 500 Selfies der Verflossenen.<br>
Der Locster schreitet genau dort ein: diese Web-Anwendung wird sich nur den wirklich wichtigen News widmen, erlaubt dir Profilstatistiken anzusehen (Wer hat sich mein Profil angeschaut?), und lässt dich mit deinen Freunden entspannt chatten!

<h2>Anforderungsbeschreibung</h2>
Die groben Ziele umfassen für den jetzigen Stand:<br>

     - Erstellung und Implementierung eines Chatsystems
     - Erstellung und Implementierung einer de.teamLocster.User.User-Datenbank
<br>
<h2>Abgrenzungskriterien</h2>
Nicht zum Projektumfang gehören:<br>

     -Erstellung eines regionalen Newsfeed
     
## Tools
>
>Wir haben während der Projektlaufzeit mit verschiedenen Tools gearbeitet wie: 
>
>	+ [Miro](https://miro.com/) - für die Planung 
>	+ [Discord](https://discord.com/) - für die Kommunikation
>	+ [IntelliJ](https://www.jetbrains.com/de-de/idea/) - IDE für Java
>	+ [lucidchart](https://www.lucidchart.com) - Tool für die Erstellung der Diagramme / Charts / ...
>	+ [Github](https://github.com/) - für zusammen coden 
>    
</details>

<details>
<summary>Diagramme</summary><br>
<h2>Klassendiagramm</h2>
<br>
Nachdem das Projekt festgelegt wurde, haben wir uns erste Ideen zur Umsetzung gemacht.
Zunächst hatten wir nur die fertige Website vor Augen und haben daher auch die Klassen je nach Unterseite gestaltet,
was natürlich die falsche Vorangehensweise war.

Somit sah das erste Klassendiagramm wie folgt aus:
![alt text](https://cdn.discordapp.com/attachments/783318437384552521/793205870074789888/JAVA1_-_alt_Klassendiagramm.jpeg)
<br>
Nach weiteren Meetings und Austausch mit anderen Projekt-Gruppen haben wir uns entschlossen,
unser bisheriges Klassendiagramm nochmal zu überholen, mit folgendem Ergebnis:
![alt text](https://cdn.discordapp.com/attachments/783318437384552521/793207517541826620/JAVA1_-_Klassendiagramm.jpeg)
<br>
Mithilfe dieses Diagrammes erarbeiteten wir uns Use Case und Aktivitätsdiagramme, welche uns im weiteren Verlauf für die eigentlichen Klassen helfen werden.
</details>

<details>
<summary>Programmcode</summary><br>
     
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
<summary>Präsentationen</summary><br>
<h2>Präsentationen 1</h2>
<br>
hier vielleicht unsere erste PowerPoint ?
<h2>Präsentationen 2</h2>
<br>
hier vielleicht unsere 2. PowerPoint ?
<h2>Präsentationen 3</h2>
<br>
hier vielleicht unsere letzte PowerPoint ?
</details>

<details>
<summary>Lessons learned</summary><br>
	
## Herausforderungen
>
>
> + Viele Projektideen am Anfang des Semesters:
>	+ die Lösung: was macht am meisten Spaß beim Implementieren und deckt gleichzeitig die ganzen Anforderungen ab
> + Zeitgrenze: viele Ideen über das Projekt, die wir nicht in der Zeit schaffen können			
>	    die Lösung: Die Anforderungen in 3 Teile unterteilen:
>	+ Musskriterien
>	+ Wunschkriterien (wenn es Zeit am Ende bleibt)
>	+ Abgrenzungkriterien
> + am Anfang jeder großen Aufgabe sieht es so aus, als sei sie unmöglich zu meistern
>	+ die Lösung: Diese Aufgabe in kleinere Teilaufgaben aufteilen und sofort mit einem Teil anfangen
	
</details>

