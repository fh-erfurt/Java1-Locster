package de.teamLocster.dummy_data;


import de.teamLocster.actions.Action;
import de.teamLocster.actions.ActionRepository;
import de.teamLocster.chat.Chat;
import de.teamLocster.chat.ChatRepository;
import de.teamLocster.chat.Message;
import de.teamLocster.chat.MessageRepository;
import de.teamLocster.enums.*;
import de.teamLocster.guestbook.GuestbookEntry;
import de.teamLocster.guestbook.GuestbookEntryRepository;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class InsertDataForSimulatingAndTesting
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    GuestbookEntryRepository guestbookEntryRepository;

    @Autowired
    MessageRepository messageRepository;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    private final LocalDate birthDay = LocalDate.ofYearDay(1990, 200);

    @Test
    void a_createTeam()
    {
        User jakob = new User(
                "jakob@gensel.de",
                encoder.encode("JAKOB"),
                "Jakob",
                "Gensel",
                "Marbach",
                birthDay,
                "Werkstudent",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Jakob",
                "Spiderman ist nicht der einzige, der klebrige Hände hat, wenn er im Netz war!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User dirk = new User(
                "dirk@hofmann.de",
                encoder.encode("DIRK"),
                "Dirk",
                "Hofmann",
                "Was weiß ich",
                birthDay,
                "Dude",
                RelationshipStatus.DIVORCED,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Dirk",
                "Na moin ihr Gesichter!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User saskia = new User(
                "saskia@wohlers.de",
                encoder.encode("SASKIA"),
                "Saskia",
                "Wohlers",
                "Erfurt",
                birthDay,
                "Dude",
                RelationshipStatus.MARRIED,
                Sex.FEMALE,
                "pseudo path",
                "Ich bin die Saskia",
                "Ahoi!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User matze = new User(
                "matthias@gabel.de",
                encoder.encode("MATZE"),
                "Matthias",
                "Gabel",
                "Erfurt",
                birthDay,
                "(M)Atze",
                RelationshipStatus.IN_A_RELATIONSHIP,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Matze",
                "Was macht eigentlich dieser Knopf?",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User molham = new User(
                "molham@al-khodari.de",
                encoder.encode("MOLHAM"),
                "Molham",
                "Al-Khodari",
                "Weimar oder so",
                birthDay,
                "Softwareentwickler",
                RelationshipStatus.SINGLE,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Molham",
                "Grins!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User[] testUsers = {jakob, dirk, saskia, matze, molham};
        for(User testUser : testUsers)
        {
            userRepository.save(testUser);
        }
    }

    @Test
    void b_createAdditionalUsers()
    {

        User dummy1 = new User(
                "dummy1@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Max",
                "Mustermann",
                "offline",
                birthDay,
                "Gärtner",
                RelationshipStatus.SINGLE,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Max",
                "Grins!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                false
        );

        User dummy2 = new User(
                "dummy2@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Tabbi",
                "Babbi",
                "offline",
                birthDay,
                "Bäcker",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.FEMALE,
                "pseudo path",
                "Ich bin Tabbi! Hiiiii",
                "Ich mag Robben",
                PrivacyStatus.PUBLIC,
                OnlineStatus.AWAY,
                false
        );

        User dummy3 = new User(
                "dummy3@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Peter",
                "Lustig",
                "online but invisible",
                birthDay,
                "Nix",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Peter",
                "Ich mag Blumen",
                PrivacyStatus.PUBLIC,
                OnlineStatus.INVISIBLE,
                true
        );

        User dummy4 = new User(
                "dummy4@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Cola",
                "Korn",
                "offline",
                birthDay,
                "Getränk",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Nur Korn bringt uns nach vorn",
                "Miau",
                PrivacyStatus.PUBLIC,
                OnlineStatus.INVISIBLE,
                false
        );

        User dummy5 = new User(
                "dummy5@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Karla",
                "Columna",
                "online but away",
                birthDay,
                "Rasende Reporterin",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Wruuuuuuuuuuum",
                "Moin!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.AWAY,
                true
        );

        User dummy6 = new User(
                "dummy6@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Tito",
                "Tintenfisch",
                "online",
                birthDay,
                "Tintenfabrikant",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin ganz ein lieber",
                "schreib mir doch!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User dummy7 = new User(
                "dummy7@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Heiko",
                "Heilbutt",
                "online",
                birthDay,
                "Fisch",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin Fisch und nicht arbeitslos :( Das ist ein VOLLZEITJOB!",
                "Lass mal um die wette schwimmen!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User dummy8 = new User(
                "dummy8@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Miro",
                "Matjes",
                "offline",
                birthDay,
                "Fisch",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin köstlich",
                "tasty tasty",
                PrivacyStatus.PUBLIC,
                OnlineStatus.AWAY,
                false
        );

        User dummy9 = new User(
                "dummy9@dummy.de",
                "5Ül2e_L3b3Rwur5t",
                "Lara",
                "Lurch",
                "online but busy",
                birthDay,
                "Taxifahrer",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin neu hier und würd mich über ein paar neue Freunde freuen! ^^",
                "tasty tasty",
                PrivacyStatus.PUBLIC,
                OnlineStatus.BUSY,
                true
        );

        User[] testUsers = {dummy1, dummy2, dummy3, dummy4, dummy5, dummy6, dummy7, dummy8, dummy9};
        for (User testUser : testUsers)
        {
            userRepository.save(testUser);
        }
    }

    @Test
    void c_createActions()
    {
        Action action1 = new Action(
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                ActionType.VISIT
        );

        Action action2 = new Action(
                userRepository.findByEmailAddress("dummy6@dummy.de").get(),
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                ActionType.FRIEND_REQUEST
        );

        Action action3 = new Action(
                userRepository.findByEmailAddress("dummy6@dummy.de").get(),
                userRepository.findByEmailAddress("saskia@wohlers.de").get(),
                ActionType.BLOCK
        );

        Action action4 = new Action(
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                userRepository.findByEmailAddress("dummy6@dummy.de").get(),
                ActionType.FRIEND_ACKNOWLEDGEMENT
        );

        Action[] testActions = {action1, action2, action3, action4};
        for(Action testAction : testActions)
        {
            actionRepository.save(testAction);
        }
    }


    @Test
    void d_createGuestbookEntries() {
        GuestbookEntry guestbookEntry1 = new GuestbookEntry(
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                "Hi schön hier dich hier zu sehen :)",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry2 = new GuestbookEntry(
                userRepository.findByEmailAddress("jakob@gensel.de").get(),
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                "Hab nen schönen Tag!",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry3 = new GuestbookEntry(
                userRepository.findByEmailAddress("jakob@gensel.de").get(),
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                "Lass mal nachher chatten lol",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry4 = new GuestbookEntry(
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                "Immer wieder toll deine Seite zu besuchen!",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry5 = new GuestbookEntry(
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                userRepository.findByEmailAddress("saskia@wohlers.de").get(),
                "Immer wieder toll deine Seite zu besuchen!",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry6 = new GuestbookEntry(
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                userRepository.findByEmailAddress("molham@al-khodari.de").get(),
                "Immer wieder toll deine Seite zu besuchen!",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry7 = new GuestbookEntry(
                userRepository.findByEmailAddress("jakob@gensel.de").get(),
                userRepository.findByEmailAddress("molham@al-khodari.de").get(),
                "Mega cooles Profilbild ^^",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry8 = new GuestbookEntry(
                userRepository.findByEmailAddress("jakob@gensel.de").get(),
                userRepository.findByEmailAddress("dirk@hofmann.de").get(),
                "Mega cooles Profilbild ^^",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry9 = new GuestbookEntry(
                userRepository.findByEmailAddress("molham@al-khodari.de").get(),
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                "Wir studieren ja das gleiche! Nice",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry10 = new GuestbookEntry(
                userRepository.findByEmailAddress("molham@al-khodari.de").get(),
                userRepository.findByEmailAddress("saskia@wohlers.de").get(),
                "Wir studieren ja das gleiche! Nice",
                getDateOf(2021, 5, 20),
                getDateOf(2021, 5, 21),
                false
        );

        GuestbookEntry guestbookEntry11 = new GuestbookEntry(
                userRepository.findByEmailAddress("molham@al-khodari.de").get(),
                userRepository.findByEmailAddress("jakob@gensel.de").get(),
                "Gott, sieht dein Bild scheiße aus! (hab das gleiche)",
                getDateOf(2021, Calendar.JULY, 20),
                getDateOf(2021, Calendar.AUGUST, 14),
                true
        );

        GuestbookEntry[] testGuestbookEntries = {guestbookEntry1, guestbookEntry2, guestbookEntry3, guestbookEntry4, guestbookEntry5, guestbookEntry6, guestbookEntry7, guestbookEntry8, guestbookEntry9, guestbookEntry10, guestbookEntry11};
        for (GuestbookEntry testGuestbookEntry : testGuestbookEntries) {
            guestbookEntryRepository.save(testGuestbookEntry);
        }
    }

    void e_createChats()
    {
        Set<User> users1 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dirk@hofmann.de").get());
        users1.add(userRepository.findByEmailAddress("dummy6@gensel.de").get());
        Chat chat1 = new Chat( "Chat1",
                users1,
                new HashSet<Message>()
        );

        Set<User> users2 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("matthias@gabel.de").get());
        users1.add(userRepository.findByEmailAddress("saskia@wohlers.de").get());
        Chat chat2 = new Chat( "Chat2",
                users1,
                new HashSet<Message>()
        );

        Set<User> users3 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dirk@hofmann.de").get());
        users1.add(userRepository.findByEmailAddress("saskia@wohlers.de").get());
        Chat chat3 = new Chat( "Chat3",
                users1,
                new HashSet<Message>()
        );

        Set<User> users4 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dummy7@gensel.de").get());
        users1.add(userRepository.findByEmailAddress("dummy6@gensel.de").get());
        Chat chat4 = new Chat( "Chat4",
                users1,
                new HashSet<Message>()
        );

        Set<User> users5 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("saskia@wohlers.de").get());
        users1.add(userRepository.findByEmailAddress("dummy6@gensel.de").get());
        Chat chat5 = new Chat( "Chat5",
                users1,
                new HashSet<Message>()
        );

        Set<User> users6 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dummy7@gensel.de").get());
        users1.add(userRepository.findByEmailAddress("molham@gabel.de").get());
        Chat chat6 = new Chat( "Chat6",
                users1,
                new HashSet<Message>()
        );

        Set<User> users7 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dirk@hofmann.de").get());
        users1.add(userRepository.findByEmailAddress("molham@gabel.de").get());
        Chat chat7 = new Chat( "Chat7",
                users1,
                new HashSet<Message>()
        );

        Set<User> users8 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("dirk@hofmann.de").get());
        users1.add(userRepository.findByEmailAddress("jakob@gensel.de").get());
        Chat chat8 = new Chat( "Chat8",
                users1,
                new HashSet<Message>()
        );

        Set<User> users9 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("jakob@gensel.de").get());
        users1.add(userRepository.findByEmailAddress("saskia@wohlers.de").get());
        Chat chat9 = new Chat( "Chat9",
                users1,
                new HashSet<Message>()
        );

        Set<User> users10 = new HashSet<User>();
        users1.add(userRepository.findByEmailAddress("jakob@gensel.de").get());
        users1.add(userRepository.findByEmailAddress("dummy7@gensel.de").get());
        Chat chat10 = new Chat( "Chat10",
                users1,
                new HashSet<Message>()
        );


        Chat[] testChats = {chat1, chat2, chat3, chat4, chat5, chat6, chat7, chat8, chat9, chat10};
        for(Chat testChat : testChats)
        {
            chatRepository.save(testChat);
        }
    }

    void f_createMessages() {
        Set<User> readBy11 = new HashSet<User>();
        Message message11 = new Message(
                userRepository.findByEmailAddress("dirk@hofmann.de").get(), // SENDER
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("dirk@hofmann.de").get()).get(0),//CHAT
                readBy11, // READ BY
                "1 geile Nachricht LOL!!!!11!!!1", // MESSAGE
                new Date(2021,5,10)  // SENT AT
        );

        Set<User> readBy12 = new HashSet<User>();
        Message message12 = new Message(
                userRepository.findByEmailAddress("dummy6@gensel.de").get(), // SENDER
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("dirk@hofmann.de").get()).get(0),//CHAT
                readBy12, // READ BY
                "Na Klar!", // MESSAGE
                new Date(2021,5,10) // SENT AT
        );

        Set<User> readBy13 = new HashSet<User>();
        Message message13 = new Message(
                userRepository.findByEmailAddress("dummy6@gensel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("dirk@hofmann.de").get()).get(0),//CHAT
                readBy13,
                "HAHHAHAHA DOPPELTEXXXXXXXXXTE lololo bot bot bot",
                new Date(2021,5,10)
        );

        Set<User> readBy14 = new HashSet<User>();
        Message message14 = new Message(
                userRepository.findByEmailAddress("dummy6@gensel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("dirk@hofmann.de").get()).get(0),//CHAT
                readBy14,
                "tripple text!!!!!!!!! ",
                new Date(2021,5,10)
        );

        Set<User> readBy21 = new HashSet<User>();
        Message message21 = new Message(
                userRepository.findByEmailAddress("molham@gabel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("saskia@wohlers.de").get()).get(0),//CHAT
                readBy21,
                "Moin du Lachs",
                new Date(2021,5,10)
        );

        Set<User> readBy22 = new HashSet<User>();
        Message message22 = new Message(
                userRepository.findByEmailAddress("saskia@wohlers.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("molham@gabel.de").get()).get(0),//CHAT
                readBy22,
                "Lachsnacken ",
                new Date(2021,5,10)
        );

        Set<User> readBy31 = new HashSet<User>();
        Message message31 = new Message(
                userRepository.findByEmailAddress("molham@gabel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("matthias@gabel.de").get()).get(1),//CHAT
                readBy31,
                "Hi Matze",
                new Date(2021,5,10)
        );

        Set<User> readBy32 = new HashSet<User>();
        Message message32 = new Message(
                userRepository.findByEmailAddress("molham@gabel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("matthias@gabel.de").get()).get(1),//CHAT
                readBy32,
                "Bin ich wirklich der Sender" +
                        "",
                new Date(2021,5,10)
        );

        Set<User> readBy33 = new HashSet<User>();
        Message message33 = new Message(
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("molham@gabel.de").get()).get(0),//CHAT
                readBy33,
                "Das weiß wohl keiner, bis wir das gleich getestet haben o_o" +
                        "",
                new Date(2021,5,10)
        );

        Set<User> readBy41 = new HashSet<User>();
        Message message41 = new Message(
                userRepository.findByEmailAddress("matthias@gabel.de").get(),
                chatRepository.findChatsByUsersContains(userRepository.findByEmailAddress("dirk@hofmann.de").get()).get(0),//CHAT
                readBy41,
                "TEST TEST TEST" +
                        "",
                new Date(2021,5,10)
        );

        Message[] testMessages = {message11};
        for(Message testMessage : testMessages)
        {
            messageRepository.save(testMessage);
        }

    }

    Date getDateOf(int year, int month, int date) {
        return new Date(year - 1900, month, date);
    }
}
