package entities;

import java.util.ArrayList;

/**
 * Created by viktorlisniak on 7/21/17.
 */
public class CategoryEntity extends BaseEntity {
    String categoryName;

    ArrayList<ArticleEntity> articles = new ArrayList<>();



    public String getCategoryName(){
        return categoryName;
    }

    public ArrayList<ArticleEntity> getArticles(){
        return articles;
    }

}
