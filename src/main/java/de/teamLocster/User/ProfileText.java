/*
===================================
== Matthias Gabel
===================================
*/
package de.teamLocster.User;

import de.teamLocster.Exceptions.ProfileTextException;

public class ProfileText
{
    /*
    ===================================
    == Variable
    ===================================
    */

    static final int MAX_NUMBER_OF_CHARS = 10000;
    public String content;

    /*
    ===================================
    == Constructor
    ===================================
    */
    public ProfileText()
    {
        this.content = "";
    }

    /*
    ===================================
    == Method
    ===================================
    */

    /**
     * checks the new text and updates the content
     * @param newText the new text of the content
     * @throws ProfileTextException throws an exception if the amount of characters is to much
     */

    public void updateContent(String newText) throws ProfileTextException
    {
        if(newText.length() < MAX_NUMBER_OF_CHARS)
        {
            this.content = newText;
        }
        else
        {
            throw new ProfileTextException("Your ProfileText has more than "+ MAX_NUMBER_OF_CHARS+" characters!");
        }
    }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */
    public String getContent() {
        return content;
    }
}
