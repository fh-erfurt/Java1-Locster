![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")
<h6>Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers</h6>

<h2>Soziales Netzwerk mit Biss</h2>
Im Rahmen der Veranstaltung "Java Programmierung 1 & 2" haben wir uns entschlossen, ein soziales Netzwerk mit Schwerpunkt auf chatten und "stalken" zu programmieren. Ganz ohne nervige Babybilder und Katzenvideos.<br>
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
     - Erstellung und Implementierung einer User-Datenbank
<br>
<h2>Abgrenzungskriterien</h2>
Nicht zum Projektumfang gehören:<br>

     -Erstellung eines regionalen Newsfeed
     
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
<h2>Sprache</h2>
<br>
Der code wird mit Englisch geschrieben, es hat Sinnvolle sprechende, englische Bezeichner. es ist kommentiert und vermeidet unnötige Redundanzen.
Jede Klasse besitzt einen einleitenden Kommentar -> hier vielleich ein photo vom code ?
Jede hinreichend komplexe Methode besitzt einen Kommentar
     
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
	<li>Der Gültigkeitsbereich der Variablen wird standartgemäß als <strong>private</strong> deklariert.
		Innerhalb der Klasse wird auf die Variablen mit <strong>this.</strong> zugegriffen.
		Außerhalb der Klasse wird dann folglich mit <strong>Settern & Gettern</strong> auf die Variablen zugegriffen.
		Anhand der <strong>Settern & Gettern</strong> erkennt man somit auch die Zugriffsrechte.
Mit einem triftigen Grund kann von der Regelung abgewichen werden.</li>
</ul>

<br>
<h2>Unit-Tests</h2>
<br>
Die Unit-Tests laufen fehlerfrei durch und erlauben es, Fehler aufzudecken
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
<br>
hier kommt ein text ....
</details>

