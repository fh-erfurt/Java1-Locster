![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

![Vercel](https://vercelbadge.vercel.app/api/Vogeslu/webaufbau-twanimal)
![5 Kommilitonen](https://img.shields.io/badge/Kommilitonen-5-yellow)

###### Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers

## Soziales_Netzwerk_mit_Kniff

### Grundidee

Im Rahmen des Java1 Projektes haben wir uns mit dem grundlegenden Klassenaufbau sowie der Umsetzung verschiedener Funktionen unseres sozialen Netzwerkes beschäftigt. Zudem haben wir uns mit den Arbeitsabläufen und der Organisation unseres Codes auseinandergesetzt. <br>
Das Projekt Locster wird ein soziales Netzwerk in dem verschiedene Nutzer sich kennenlernen, gegenseitig als Freunde hinzufügen, miteinander chatten und Gästebucheinträge schreiben können. 

### Aktueller Stand

Wir haben ein kleines soziales Netzwerk erstellt, auf dem sich Users registrieren und anmelden können.
Grundlegende Funktionen, wie Erstellen von Beiträgen, suche nach User, Freundschaftsanfrage senden bzw. empfangen, Konto verwaltung ist komplett integriert und funktioniert.
Dazu kann man sein eigenes Profil frei gestalten und anpassen.

Chat wurde in finale Fassung übernommen, da diese Funktionen den Ramen gesprengt hätten.



## Projektteam

* **Dirk Hofmann** - [Profil](https://github.com/Munchkin129)
* **Jakob Gensel** - [Profil](https://github.com/bro-scientist)
* **Matthias Gabel** - [Profil](https://github.com/f0rkster)
* **Molham Al-Khodari** - [Profil](https://github.com/Molham321)
* **Saskia Wohlers** - [Profil](https://github.com/schnoernja)

## Projektstruktur
In unserem Stammverzeichnis findet man folgendes:
* **Javadoc** - 
    In diesem Verzeichnis findet man das Javadoc. Diese wird durch Ausführen der index.html Datei gestartet.
* **profile-picture** - 
    Dieses Verzeichnis wird erst angelegt, wenn Profilbilder hochgeladen werden.
    Man findet hier das Profil der jeweiligen User nach folgenden Bezeichnungsmustern.
    picture-[4].[Dateiformat-Endung]
* **Projektdokumentation**
* **Projektdokumentation/Präsentation** - 
    Hier findet man die Präsentationen des diesigen und vergangenen Semesters
* **Projektdokumentation/screenshot** - 
    Hier findet man die in den Präsentation und in der Dokumentation verwendeten Screenshots
* **src**
* **src/main**
* **src/main/java** - 
    hier findet man sämtliche Packages mit den jeweiligen repositories, services und classes
* **src/main/resources** - 
    hier findet man die *.html, *.css und *.js Dateien
* **test** -
    hier findet man sämtlich Tests zum Projekt

## Installation

### 1. Repository klonen

#### 1.1 Ordner auswählen und cmd öffnen
HTTPS-Variante: 

```
git clone https://github.com/fh-erfurt/Java1-Locster.git
```

SSH-Variante: 

```
git clone git@github.com:fh-erfurt/Java1-Locster.git
```

### Alternative: 1. Git initialisieren und Remote-Branch hinzufügen

#### 1. Projektordner erstellen und cmd öffnen

```
git init
git remote add origin https://github.com/fh-erfurt/Java1-Locster.git
git pull origin main
```

### 2. Datenbank erstellen

Erstellen Sie eine Datenbank auf Ihrem MySQL-Server. Bspw. ``locster``

### 3. Datenbank-Schema importieren

Um das aktuelle Datenbankschema zu importieren machen Sie folgenden:

```
1. IntelliJ IDEA öffnen
2. auf der rechte Seite im right-nav Database drüchen
3. auf dem Plus drücken -> data Source -> MySQL wählen
4. schreiben Sie bei Database: locster, bei User:root, mehr nicht. 

Sie müssen nun project test laufen lassen: mit dem rechte taste maus auf java (unter test) drücken -> Run All Tests
```

### 4. Starten des Servers

Um den Server zu starten geben Sie bitte folgenden machen

1. gehen sie zu src -> main -> java -> de.teamLocster -> ServingWebContentApplication
2. Sie müssen ServingWebContentApplication lausen lassen "Run"

3. gehen sie zu src -> test -> dummy_data -> InsertDataForSimulatingAndTesting
4. Sie müssen InsertDataForSimulatingAndTesting lausen lassen "Run"

Sie Dürfen auf ihrem Browser localhost:8080/ rufen 

5. email: dirk@hofmann.de	Passwort:DIRK
	
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

## Projektpräsentation

### java 1

Link zum [1.Präsentation - Team & Project Vorstellen](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/Pr%C3%A4sentation/JAVA1/Team%20%26%20Project%20Vorstellen.pdf)<br>
Link zum [2.Präsentation - Zwischen_prasentation_1](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/Pr%C3%A4sentation/JAVA1/Zwischen_prasentation_1.pdf)<br>
Link zum [3.Präsentation - finale_java_presentation](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/Pr%C3%A4sentation/JAVA1/finale_java_presentation1.pdf)<br>

### java 2

Link zum [1.Präsentation - Team & Project Vorstellen](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/Pr%C3%A4sentation/JAVA2/1.Pr%C3%A4sentation%20Java2.pdf)<br>
Link zum [2.Präsentation - finale_java_presentation](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/Pr%C3%A4sentation/JAVA2/2.Pr%C3%A4sentation%20Java2.pdf)<br>

## tools
	
* Git
* GitHub
* Discord
* intellij
* Visual Studio Code
* maven
* junit
* Figma
* lucidchart
* miro
* fontawesome

## Lessons Learned

<details>

<summary>Lessons Learned</summary>
	


* **Feste Aufgabenverteilung:** ohne feste Aufgabenverteilung wurden so manche Sachen doppelt gemacht oder gar nicht. Es ist essenziell jede Aufgabe einer Person zuzuordnen, damit auch jeder was zu tun hat und das Projekt vorangeht. Außerdem wird so verhindert, dass man unnötige Funktionen o.Ä. schreibt, welche eigentlich gar nicht gebraucht werden.

* **Objektstruktur ohne Anwendung:** der Umfang und die konkrete Umsetzung eines Projektes ist schwer vorstellbar und sehr abstrakt ohne Bezug zur Anwendung. Gerade dadurch, dass wir vom Modul Java 1 diesbezüglich etwas eingeschränkt wurden (keine Datenbank; für unsere Anwendung leider der Grundpfeiler).

* **Umgang mit Github:** nie vergessen eine eigene Branch anzulegen, Commits sind geil und es wäre vom Vorteil nicht nur einmal die Woche eine Pull-Request zu starten.

* **Testen ist geil:** testen ist einfach geil.

* **Grundlagen Java:** natürlich die größte Lessons Learned in diesem Projekt!

* **Projektstrukturierung und Zeitplanung:** Eine gute Projektstrukturierung und Zeitplanung ist notwendig um das Projekt voranzubringen. Ohne feste Struktur in der Vorgehensweise macht jeder einfach irgendwas und nichts funktioniert wirklich miteinander. Auch ist Kommunikation zwischen den Teammitgliedern hierbei ein wichtiger Schlüssel zum Erfolg.

* **Kleinigkeiten sind keine Kleinigkeiten:** Kleinigkeiten benötigen fast IMMER mehr Zeit als "mal eben kurz..". Deshalb sollte man diese "Kleinigkeiten" (z.B. Aktualisierung des Klassendiagrammes, Namens-Änderung von Variablen oder Funktionen, etc) am besten sofort erledigen!

</details>

## Diagramme

<details>
	
<summary>Diagramme</summary><br>
	
## Klassendiagramm <br>
	
Das Klassendiagramm enthält die logische Struktur der Klassen und unterteilt diese in farblich gekennzeichnete Packages.
	
![Klassendiagramm](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/KlassendiagrammJava2.png) <br>

Jedes Klasse in einem Package hat ein Repository das mit der Datenbank kommuniziert, einen Service indem sich die Logik befindet und ein Controller der die Anfragen entgegen nimmt.

<details>
<summary>Chat Package</summary><br>

Die Klasse **Chat**  enthält die Informationen welche User in einem Chat sind. Die Klasse **Message** bewahrt die Informationen über den Verfasser der Nachricht, den Inhalt dieser, sowie die Uhrzeit wann sie abgeschickt worden ist.
Die Funktionalität wurde in diesem Projekt nicht umgesetzt.

</details>

<details>
<summary>Action Package</summary><br>
	
Die Klasse **Action** ist der Mittelpunkt. Hier werden verschiedene Aktionen des Users durch das Enum ActionType aufgelistet, z.B. *VISIT*, *FRIEND_REQUEST*, *FRIEND_ACKNOWLEDGEMENT* und *BLOCK*.
Mittels der FRIEND-Aktionen werden Freundschaften realisiert.
Die Aktionen sind leicht erweiterbar.

</details>

<details>
<summary>Guestbook Package</summary><br>

Die Klasse **GuestbookEntry**  enthält den Speicherort für die Einträge im Gästebuch. Die Klasse bewahrt die Informationen über den Verfasser und Empfänger des Eintrages, den Inhalt, sowie die Uhrzeit wann der Eintrag bearbeitet worden ist.

</details>

<details>
<summary>User Package</summary><br>
	
Über unseren **User** werden alle User abgespeichert. Hier werden alle relevanten Userdaten gespeichert.
Über *registerUser* im **UserService** werden neue User angelegt. 
	
</details>
</details>

## Codestyle

1. Sprache<br>
<br>
<ul>
<li>Code und Kommentare werden in Englisch verfasst.</li>
</ul>
<br>
2. Klassen<br>
<br>
<ul>
	<li>Klassenname sowie Dateiname werden in <strong>UpperCamelCase</strong> geschrieben</li>
<li>Beispiel: ClassName.java</li>
</ul>

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
5. Tests<br>
<br>
<ul>
	<li>Test-Klassen werden in der Ordnerstrukter unter <strong>src/test...</strong> angelegt.</li>
	<li>Test sowie Dateiname werden in <strong>UpperCamelCase</strong> geschrieben und enden mit dem Suffix "Test"</li>
<li>Beispiel: ClassNameTest.java</li>
	<li>Die Tests sollen einen aussagekräftigen Bezeichner erhalten und sind wie folgt aufgebaut</li>
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
6. Enum<br>
<br>
<ul>
	<li>Enums werden in <strong>UpperCamelCase</strong> geschrieben</li>
</ul>
	
</details>
</details>
	
## Funktionalitäten

<details>
<summary>Datenpersistierung</summary>
	
## Datenpersistierung
	
Um die Daten zu sichern existiert eine Datenbankanbindung.
</details>
	
<details>
<summary>Registrierung</summary>
	
## Registrierung
	
Um Locster nutzen zu können, muss man sich vorher registrieren.
	
![SignUp](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/SignUp.png)
	
Man gibt folgendes an:
* Name und Vorname
* Alter
* Geschlecht
* E-Mail
* Passwort
	
Das Passwort muss aus mindestens acht Zeichen, davon ein Großbuchstabe, ein Kleinbuchstabe, eine Zahl und einem Sonderzeichen bestehen. 
Zur Übersicht gibt es im Browser bereits ein Feedback, was noch beim Passwort fehlt. 

</details>

<details>
<summary>Login/Logout</summary>
	
## Login/Logout
	
Hat man bereits einen Account, kann man sich nun einloggen. Oben rechts gibt es einen Verweis auf die Registrierung.
	
![LogIn](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/LogIn.png)
	
Eingeloggt kann man sich jederzeit wieder ausloggen.
</details>
	
<details>
<summary>Navigation</summary>
	
## Navigation
	
Oben in der Navigationsleiste kann man leicht wechseln zwischen:
* Chat
* Wer ist Online?
* Freundschaften
* eigenem Profil
* Einstellungen
* Logout
	
</details>

<details>
<summary>Wer ist Online?</summary>
	
## Wer ist Online?
	
![Wer ist Online](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Who_Is_Online.png)
	
Hier sieht man alle Nutzer aufgelistet, die gerade online sind.
Es sind ein paar Information zu jedem Nutzer aufgelistet.
Von hier aus kann man auf die verschiedenen Profile der Nutzer gelangen.
</details>	

<details>
<summary>Freundschaften</summary>
	
## Freundschaften
	
![Freunde](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Freunde.png)
	
Auf dieser Seite sieht man alle eingegangenen Freundschaftsanfragen und alle bestätigten Freundschaften.
Hier kann man erhaltene Freundschaftsanfragen annehmen oder ablehnen.
Bestätigte Freunde kann man besuchen und entfernen.
Um einer anderen Person eine Freundschaftsanfrage zu stellen, muss man auf das Profil der Person gelangen. Nur dort kann man eine Anfrage stellen.

</details>	
	
<details>
<summary>Eigenes Profil</summary>
	
## Profilansicht
	
![Mein Profil](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Mein_Profil.png)
	
Im ersten Abschnitt sind die persönliches Informationen zu sehen, wie Name oder Geburtstag.
Der zweite Abscnhitt ist der ist der persönliche Profiltext, der dort auch gleich bearbeitet werden kann.
Danach kommen Gäastebucheinträge von Personen, die dein Profil besucht haben.
Am Schluss und nur für einen selbst sichtbar sind die eigen verfassten Gästebucheinträge.
	
## Profilverwaltung
	
![Einstellungen](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Settings.png)	
	
Man gelangt hier hin entweder über das Stift-Icon im ersten Abschnitt oder über Einstellungen.
Hier kann man seine persönlichen Daten ändern, einen Status einstellen, seinen online Status ändern, sein Passwort ändern und ein Profilbild hochladen.
Ganz unten lässt sich das Profil aich löschen.

</details>

<details>
<summary>Gästebucheinträge</summary>
	
## Gästebucheinträge

Wenn man das Profil einer anderen Person besucht, kann man dort einen netten Eintrag hinterlassen.
	
![Anderes Profil](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Anderes_Profil.png)	

</details>

<details>
<summary>Suchfunktion</summary>
	
## Suchfunktion
	
Bei der Suche werden alle Personennamen und Ort durchgegangen.
</details>
	
<details>
<summary>Verschiedenes</summary>
	
## Verschiedenes
	
Es existiert eine Chatseite, jedoch ohne Funktionalität.
Das Impressum, eine Datenschutzerklärung und eine 404-Seite snd ebfalls vorhanden.
	
</details>
