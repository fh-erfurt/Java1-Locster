![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

[![Build Status](https://github.com/fh-erfurt/Java1-Locster/workflows/build/badge.svg)](https://github.com/fh-erfurt/Java1-Locster/actions)
![Vercel](https://vercelbadge.vercel.app/api/Vogeslu/webaufbau-twanimal)
![5 Kommilitonen](https://img.shields.io/badge/Kommilitonen-5-yellow)

###### Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers

## Soziales_Netzwerk_mit_Kniff

### Grundidee

Im Rahmen des Java1 Projektes haben wir uns mit dem grundlegenden Klassenaufbau sowie der Umsetzung verschiedener Funktionen unseres sozialen Netzwerkes beschäftigt. Zudem haben wir uns mit den Arbeitsabläufen und der Organisation unseres Codes auseinandergesetzt. <br>
Das Projekt Locster wird ein soziales Netzwerk in dem verschiedene Nutzer sich kennenlernen, gegenseitig als Freunde hinzufügen, miteinander chatten und Gästebucheinträge schreiben können. 

### Aktueller Stand (Todo)

Wir haben ein kleines soziales Netzwerk erstellt, auf dem sich Users registrieren und anmelden können.
Grundlegende Funktionen, wie Erstellen von Beiträgen, suche nach User, Freundschaftsanfrage senden bzw. empfangen, Konto löschen ist komplett integriert und funktioniert.
Dazu kann man sein eigenes Profil frei gestalten und anpassen.

Chat wurde in finale Fassung übernommen, da diese Funktionen den Ramen gesprengt hätten.



## Projektteam

* **Dirk Hofmann** - [Profil](https://github.com/Munchkin129)
* **Jakob Gensel** - [Profil](https://github.com/bro-scientist)
* **Matthias Gabel** - [Profil](https://github.com/f0rkster)
* **Molham Al-Khodari** - [Profil](https://github.com/Molham321)
* **Saskia Wohlers** - [Profil](https://github.com/schnoernja)

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

#### 1.1 Projektordner erstellen und cmd öffnen

```
git init
git remote add origin https://github.com/fh-erfurt/Java1-Locster.git
git pull origin main
```

### 2. Datenbank erstellen

Erstellen Sie eine Datenbank auf Ihrem MySQL-Server. Bspw. ``locster``

### 5. Datenbank-Schema importieren

Um das aktuelle Datenbankschema zu importieren machen Sie folgenden:

```
1. IntelliJ IDEA öffnen
2. auf der rechte Seite im right-nav Database drüchen
3. auf dem Plus drücken -> data Source -> MySQL wählen
4. schreiben Sie bei Database: locster, bei User:root, mehr nicht. 

Sie müssen nun project test laufen lassen: mit dem rechte taste maus auf java (unter test) drücken -> Run All Tests
```

### 6. Starten des Servers

Um den Server zu starten geben Sie bitte folgenden machen

1. gehen sie zu src -> main -> java -> de.teamLocster -> ServingWebContentApplication
2. Sie müssen ServingWebContentApplication lausen lassen "Run"

3. gehen sie zu src -> test -> dummy_data -> InsertDataForSimulatingAndTesting
4. Sie müssen InsertDataForSimulatingAndTesting lausen lassen "Run"

Sie Dürfen auf ihrem Browser localhost:8080/ rufen 
	
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
User werden bewusst als ganzer User abgespeichert, im nächsten Semester werden User per UserID referenziert.
	
![Klassendiagramm](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/JAVA1%20-%20Klassendiagramm_NEW.png) <br>


<details>
<summary>Chat Package</summary><br>

Die Klasse **Chat**  enthält den Speicherort - eine ArrayList in diesem Fall - für die im Chat gesendeten Nachrichten. Die Klasse **Message** bewahrt die Informationen über den Verfasser der Nachricht, den Inhalt dieser, sowie die Uhrzeit wann sie abgeschickt worden ist.
Mithilfe der Funktion **sendToChat** wird die Nachricht über die Funktion **recieveMessage** an die **ArrayList<Messages>** in der **Chat-Klasse** übergeben.

![chat](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/chat.png) <br>

</details>

<details>
<summary>Friend Package</summary><br>
	
Die Klasse **FriendList** ist der Mittelpunkt. Hier ist die komplette Funktionalität zu finden.
Jeder User hat eine ArrayList **acceptedFriends**, in der die bestätigten Freundschaften hinterlegt sind und eine ArrayList **waitingFriends**, in der gesendete und empfangene Freundschaftsanfragen zu finden sind.
* **FriendListItem** dient als Eintrag in der ArrayList "acceptedFriends". Dort ist der befreundete User mit einer LocalDateTime seit Beginn der Freundschaft hinterlegt.
* **FriendRequest** dient als Eintrag in der ArrayList "waitingFriends". Dort sind der Absender und der Empfänger der Anfrage gespeichert.
* User haben die Grundlegenden Fähigkeiten, anderen Usern **Freundschaftsanfragen zu schicken**, **Freundschaftsanfragen zu akzeptieren oder zu verweigern** und **bestätigte Freunde zu entfernen**.
* Freundschaftsanfragen werden beim **Absender und beim Empfänger gespeichert**. User können selbst geschickte Anfragen nicht annehmen, diese aber zurückziehen (ablehnen). Empfangene Freundschaftsanfragen können angenommen oder abgelehnt werden. 
* Die beiden Exceptions **CannotSendFriendRequestException** und **CannotAcceptFriendRequestException** werden in Methoden in der FriendList verwendet.
	
![friend](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/friend.png) <br>

</details>

<details>
<summary>Guestbook Package</summary><br>

Die Klasse **Guestbook**  enthält den Speicherort - eine ArrayList in diesem Fall - für die Einträge im Gästebuch. Die Klasse **GuestbookEntry** bewahrt die Informationen über den Verfasser des Eintrages, den Inhalt, sowie die Uhrzeit wann der Eintrag bearbeitet worden ist. 
Mithilfe der Funktion **addEntry** wird ein Eintrag erstellt, **editEntry** lässt einen Eintrag bearbeiten und updaten und **deleteEntry** gibt die Möglichkeit, diesen zu löschen.
	
![guestbook](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/guestbook.png) <br>

</details>

<details>
<summary>User Package</summary><br>
	
In unserem **UserContainer** werden alle User abgespeichert. Über diese Klasse kann man User anlegen, entfernen und gewisse Attribute ändern. Letztere Funktionalität (changeUsername, changeMailadress, changePassword) wird zu einem späteren Zeitpunkt in die AccountDetails Klasse verschoben.

* Über die **User Klasse** kann man auf alle Attribute zugreifen und gegebenenfalls verändern. 
* In der **ProfilText** Klasse findet man den Content des ProfilTextes.
* **AccountDetails** enthält alle Informationen zum Login.
* **PersonalInfo** enthält alle Daten, die die Person betreffen.
* **ProfileStatistic** hier werden die statistischen Daten des Profils gehalten und aktualisiert.
* **TestUtility** hier findet man Hilfsfunktionen für die Tests.
* **ValidationUtility** hier findet man Hilfsfunktionen für das Überprüfen verschiedener Werte.


![user1](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user1.png) <br>
![user2](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user2.png) <br>

</details>

<details>
<summary>Exceptions & ValidationUtility package</summary><br>

Die Klasse **ValidationUtilty** enthält alle Funktionen, die zur Validierung eines neuen Users benötigt werden. Die Funktion **stringAlreadyExistsInArray** zum Beispiel überprüft in der **ArrayList<User>** ob die E-mail-Addresse schon zu einem anderen User gehört. 
	
Die Klasse **TestUtility** enthält eine Hilfsfunktion (getNewUserForTesting) um Standart-User für Testfälle einfacher anlegen zu können.
	
Die Klasse **Exceptions** enthält die Exceptions die ausgeworfen werden, wenn ein Problem während der Ausführung einer Funktion auftritt; beispielsweise, dass das vom User gewählte Passwort den Anforderungen nicht entspricht.
	
![rest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/exception.png) <br>
![rest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/ValidationUtility.png) <br>
![rest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/TestUtility.png) <br>

</details>
	
## Aktivitätsdiagramme

<details>
<summary>registerUser</summary><br>

Die Funktion <strong>registerUser</strong> legt einen User an. Hierfür ruft sie weitere Funktionen auf, damit die Eingaben des neuen Nutzers auch den gültigen Anforderungen entsprechen.

<strong>checkEmail</strong> überprüft die E-Mail-Adresse auf "@"-Zeichen und Eindeutigkeit.
![registerUsercheckemail](https://cdn.discordapp.com/attachments/783318437384552521/805088682809098250/Screenshot_143.png) <br>

<strong>checkPassword</strong> überprüft das Passwort auf die benötigten Zeichen/-Anzahl und Sonderzeichen.
![validemail](https://cdn.discordapp.com/attachments/783318437384552521/805088723191988224/Screenshot_148.png) <br>

<strong>checkUsername</strong> überprüft den Benutzernamen auf genügend Zeichen.
![validusername](https://cdn.discordapp.com/attachments/783318437384552521/805088754536284180/Screenshot_149.png) <br>

	
</details>

<details>
<summary>acceptFriendRequest</summary><br>
	
Die Methode <strong>acceptFriendRequest</strong> akzeptiert eine Freundschaftsanfrage. Sie ruft weitere Methoden auf: 
* um einen Eintrag in 'acceptedFriends' bei beiden Usern anzulegen
* um den Eintrag (die abzuarbeitende Freundschaftsanfrage) aus 'waitingFriends' bei beiden Usern zu entfernen
* um in ProfileStatistic latest- und oldestFriend bei beiden Usern zu aktualisieren
![acceptFriendRequest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/acceptFriendRequest.png) <br>

Die Methode <strong>removeEntryFromWaitingFriends</strong> durchsucht 'waitingFriends' solange, bis der Eintrag mit dem übergebenen User gefunden wurde und entfernt diesen. Es ist wichtig zu wissen, ob der übergebene User als 'sender' oder 'receiver' abgespeichert ist.
![removeEntryFromWaitingFriends](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/removeEntryFromWaitingFriends.png) <br>

</details>
<hr>
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
	<li>Klassen werden in der Ordnerstruktur unter <strong>src/main...</strong> angelegt</li>
	<li>Klassenname sowie Dateiname werden in <strong>UpperCamelCase</strong> geschrieben</li>
<li>Beispiel: ClassName.java</li>
<li>Die Strukturierungen der Klassen sehen wie folgt:</li>
</ul>

 <br>
 
    1. Enum
    2. Konstanten und Klassenvariablen 
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
7. Enum<br>
<br>
<ul>
	<li>Enums werden in <strong>UpperCamelCase</strong> geschrieben</li>
	<li>Beispiel für Enum:</li>
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
    
    private Example example = Example.value1;
     
<br>
	
## Funktionalitäten

<details>
<summary>Datenpersistierung</summary>
## Datenpersistierung
</details>
	
<details>
<summary>Registrierung</summary>
	
## Registrierung
	
Um Locster nutzen zu können, muss man sich vorher registrieren.
	
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
</details>
	
<details>
<summary>Navigation</summary>
	
## Navigation
	

</details>

<details>
<summary>Profilverwaltung</summary>
## Profilverwaltung
</details>

<details>
<summary>Wer ist Online?</summary>
## Wer ist Online?
</details>

<details>
<summary>Gästebucheinträge</summary>
## Gästebucheinträge
</details>
	
<details>
<summary>Freundschaften</summary>
## Freundschaften
</details>

<details>
<summary>Suchfunktion</summary>
## Suchfunktion
</details>
	
<details>
<summary>Verschiedenes</summary>
## Verschiedenes
</details>
