package entities;

import java.util.ArrayList;

/**
 * Created by viktorlisniak on 7/21/17.
 */
public class CategoryEntity extends BaseEntity {
    String categoryname;

    ArrayList<ArticleEntity> articles = new ArrayList<>();



    public String getCategoryName(){
        return categoryname;
    }

    public ArrayList<ArticleEntity> getArticles(){
        return articles;
    }

}
