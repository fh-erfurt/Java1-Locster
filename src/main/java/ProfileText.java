public class ProfileText
{
    static final int MAX_NUMBER_OF_CHARS = 10000;
    public String content;

    public ProfileText(String content)
    {
        this.content = content;
    }

    /*
    ===================================
    Getter & Setter
    ===================================
    */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
