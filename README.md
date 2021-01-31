![alt text]( https://cdn.discordapp.com/attachments/783318437384552521/793117042214567946/locsterw3_2.png "Logo Title Text 1")

[![Build Status](https://github.com/fh-erfurt/Java1-Locster/workflows/build/badge.svg)](https://github.com/fh-erfurt/Java1-Locster/actions)

###### Ein Java-Projekt von Dirk Hofmann, Jakob Gensel, Matthias Gabel, Molham Al-Khodari, Saskia Wohlers

## Soziales_Netzwerk_mit_Kniff

Im Rahmen des Java1 Projektes haben wir uns mit dem grundlegenden Klassenaufbau sowie der Umsetzung verschiedener Funktionen unseres sozialen Netzwerkes beschäftigt. Zudem haben wir uns mit den Arbeitsabläufen und der Organisation unseres Codes auseinandergesetzt. <br>
<br>

Das Projekt Locster wird ein soziales Netzwerk in dem verschiedene Nutzer sich kennenlernen, gegenseitig als Freunde hinzufügen, miteinander chatten und Gästebucheinträge schreiben können. 

## Projektteam

* **Dirk Hofmann** - [Profil](https://github.com/Munchkin129)
* **Jakob Gensel** - [Profil](https://github.com/bro-scientist)
* **Matthias Gabel** - [Profil](https://github.com/f0rkster)
* **Molham Al-Khodari** - [Profil](https://github.com/Molham321)
* **Saskia Wohlers** - [Profil](https://github.com/schnoernja)
	
## Codestyle

1. Sprache<br>
<br>
<ul>
<li>Code und Kommentare werden in englisch verfasst.</li>
</ul>
<br>
2. Klassen<br>
<br>
<ul>
	<li>Klassen werden in der Ordnerstruktur unter <strong>src/main...</strong> angelegt.</li>
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

 <a href="https://github.com/fh-erfurt/Java1-Locster/blob/mal-readme/Projektdokumentation/Team%20%26%20Project%20Vorstellen.pdf">Team & Project vorstellen</a> <br>
 <a href="https://github.com/fh-erfurt/Java1-Locster/blob/mal-readme/Projektdokumentation/Team%20%26%20Project%20Vorstellen.pdf">Project zwischenpräsentation</a> <br>
 <a href="https://github.com/fh-erfurt/Java1-Locster/blob/mal-readme/Projektdokumentation/Team%20%26%20Project%20Vorstellen.pdf">Project finale präsentation</a> <br>

<details>
<summary>Diagramme</summary><br>
	
## Klassendiagramm <br>
	
Das Klassendiagramm enthält die logische Struktur der Klassen und unterteilt diese in farblich gekennzeichnete Packages.
	
![Klassendiagramm](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/JAVA1%20-%20Klassendiagramm_NEW.png) <br>


<details>
<summary>Chat Package</summary><br>

Die Klasse **Chat**  enthält den Speicherort - eine ArrayList in diesem Fall - für die im Chat gesendeten Nachrichten. Die Klasse **Message** bewahrt die Informationen über den Verfasser der Nachricht, den Inhalt dieser, sowie die Uhrezeit wann sie abgeschickt worden ist.
Mithilfe der Funktion **sendToChat** wird die Nachricht über die Funktion **recieveMessage** an die **ArrayList<Messages>** in der **Chat-Klasse** übergeben.

![chat](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/chat.png) <br>

</details>

<details>
<summary>Friend Package</summary><br>
	
Die Klasse **FriendList** ist der Mittelpunkt. Hier ist die komplette Funktionalität zu finden.
Jeder User hat eine ArrayList **acceptedFriends**, in der die bestätigten Freundschaften hinterlegt sind und eine ArrayList **waitingFriends**, in der gesendete und empfangene Freundschaftsanfragen zu finden sind.
* **FriendListItem** dient als Eintrag in der ArrayList "acceptedFriends". Dort ist der befreundete User mit einer LocalDateTime seit Beginn der Freundschaft hinterlegt.
* **FriendRequest** dient als Eintrag in der ArrayList "waitingFriends". Dort ist der Absender und der Empfänger der Anfrage gespeichert.
* User haben die Grundlegenden Fähigkeiten, anderen Usern **Freundschaftsanfragen zu schicken**, **Freundschaftsanfragen zu akzeptieren oder zu verweigern** und **bestätigte Freunde zu entfernen**.
* Freundschaftsanfragen werden beim **Absender und beim Empfänger gespeichert**. User können selbst geschickte Anfragen nicht annehmen, diese aber zurückziehen (ablehnen). Empfangene Freundschaftsanfragen können angenommen oder abgelehnt werden. 
* Die beiden Exceptions **CannotSendFriendRequestException** und **CannotAcceptFriendRequestException** werden in Methoden in der FriendList verwendet.
	
![friend](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/friend.png) <br>

</details>

<details>
<summary>Guestbook Package</summary><br>

Die Klasse **Guestbook**  enthält den Speicherort - eine ArrayList in diesem Fall - für die Einträge im Gästebuch. Die Klasse **GuestbookEntry** bewahrt die Informationen über den Verfasser des Eintrages, den Inhalt diesen, sowie die Uhrezeit wann der Eintrag bearbeitet worden ist. 
Mithilfe der Funktion **addEntry** wird ein Eintrag erstellt, **editEntry** lässt einen Eintrag bearbeiten und updaten und **deleteEntry** gibt die Möglichkeit, diesen zu löschen.
	
![guestbook](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/guestbook.png) <br>

</details>

<details>
<summary>User Package</summary><br>
	
In unserem **UserContainer** werden alle User abgespeichert. Über diese Klasse kann man User anlegen, entfernen und gewisse Attribute ändern. Letztere Funktionalität (changeUsername, changeMailadress, changePassword) wird zu einem späteren Zeitpunkt in die AccountDetails Klasse verschoben.

* Über die **User Klasse** kann man auf alle Attribute zugreifen und gegebenenfalls verändern. 
* In der **ProfilText** Klasse findet man den Content des ProfilTextes.
* **AccountDetails** enthält alle Informationen zum Login.
* **PersonalInfo** enthält alle Daten die die Person betreffen.
* **ProfileStatistic** hier werden die statistischen Daten des Profils gehalten und aktualisiert.
* **TestUtility** hier findet man Hilfsfunktionen für die Tests.
* **ValidationUtility** hier findet man Hilfsfunktionen für das Überprüfen verschiedener Werte.


![user1](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user1.png) <br>
![user2](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/user2.png) <br>

</details>

<details>
<summary>Exceptions & ValidationUtility package</summary><br>

Die Klasse **ValidationUtilty** enthält alle Funktionen die zur Validierung eines neuen Users benötigt werden. Die Funktion **stringAlreadyExistsInArray** zum Beispiel überprüft in der **ArrayList<User>** ob die Email-Addresse schon zu einem anderen User gehört. 
	
Die Klasse **Exceptions** enthält die Exceptions die ausgeworfen werden, wenn ein Problem während der Ausführung einer Funktion auftritt; beispielsweise dass das vom User gewählte Passwort den Anforderungen nicht entspricht.
	
![rest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/Exceptions%26ValidationNEW.png) <br>

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
	
Die Methode <strong>acceptFriendRequest</strong> akzeptiert eine Freunschaftsanfrage. Sie ruft weitere Methoden auf: 
* um einen Eintrag in 'acceptedFriends' bei beiden Usern anzulegen
* um den Eintrag (die abzuarbeitende Freundschaftsanfrage) aus 'waitingFriends' bei beiden Usern zu entfernen
* um in ProfileStatistic latest- und oldestFriend bei beiden Usern zu aktualisieren
![acceptFriendRequest](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/acceptFriendRequest.png) <br>

Die Methode <strong>removeEntryFromWaitingFriends</strong> durchsucht 'waitingFriends' solange, bis der Eintrag mit dem übergebenen User gefunden wurde und entfernt diesen. Es ist wichtig zu wissen, ob der übergebene User als 'sender' oder 'receiver' abgespeichert ist.
![removeEntryFromWaitingFriends](https://github.com/fh-erfurt/Java1-Locster/blob/main/Projektdokumentation/screenshot/removeEntryFromWaitingFriends.png) <br>

</details>
<hr>
</details>


<details>
<summary>Verwendete Technologien</summary>
	
## tools

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

<summary>Lessons Learned</summary>
	
## Lessons Learned

* **Feste Aufgabenverteilung:** ohne feste Aufgabenverteilung wurden so manche Sachen doppelt gemacht oder gar nicht. Es ist essenziell jede Aufgabe einer Person zuzuordnen, damit auch jeder was zu tun hat und das Projekt vorangeht. Außerdem wird so verhindert, dass man unnötige Funktionen o.Ä. schreibt, welche eigentlich gar nicht gebraucht werden.

* **Objektstruktur ohne Anwendung:** der Umfang und die konkrete Umsetzung eines Projektes ist schwer vorstellbar und sehr abstrakt ohne Bezug zur Anwendung. Gerade dadurch, dass wir vom Modul Java 1 diesbezüglich etwas eingeschränkt wurden (keine Datenbank; für unsere Anwendung leider der Grundpfeiler).

* **Umgang mit Github:** nie vergessen eine eigene Branch anzulegen, Commits sind geil und es wäre vom Vorteil nicht nur einmal die Woche eine Pull-Request zu starten.

* **Testen ist geil:** testen ist einfach geil.

* **Grundlagen Java:** natürlich die größte Lessons Learned in diesem Projekt!

* **Projektstrukturierung und Zeitplanung:** Eine gute Projektstrukturierung und Zeitplanung ist notwendig um das Projekt voranzubringen. Ohne feste Struktur in der Vorgehensweise macht jeder einfach irgendwas und nichts funktioniert wirklich miteinander. Auch ist Kommunikation zwischen den Teammitgliedern hierbei ein wichtiger Schlüssel zum Erfolg.

* **Kleinigkeiten sind keine Kleinigkeiten:** Kleinigkeiten benötigen fast IMMER mehr Zeit als "mal eben kurz..". Deshalb sollte man diese "Kleinigkeiten" (z.B. Aktualisierung des Klassendiagrammes, Namens-Änderung von Variablen oder Funktionen, etc) am besten sofort erledigen!

</details>
	
## Ausblick Java2

* Für das kommende Semester haben wir uns bereits folgende Ziele gesetzt:
    * **Datenbank für die Speicherung der Nutzerdaten**
    * **Nutzeroberfläche/Webseite**

</details>

