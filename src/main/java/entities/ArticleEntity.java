package entities;

/**
 * Created by viktorlisniak on 7/24/17.
 */
public class ArticleEntity extends BaseEntity {
    String title;
    String author;
    String date;

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getDate(){
        return date;
    }
}
