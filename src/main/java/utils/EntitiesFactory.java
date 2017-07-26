package utils;

import entities.AddressEntity;
import entities.ItemEntity;
import entities.UserEntity;
import entities.CategoryEntity;

import java.io.File;

/**
 * Created by odiachuk on 13.07.17.
 */
public class EntitiesFactory {

    public static UserEntity getUser(String dataFile) throws Exception {
        UserEntity user = new UserEntity();
        user = JSONReader.toObjectFromFile(UserEntity.class, dataFile);
        return user;
    }

    public static ItemEntity getItem(String dataFile) throws Exception {
        return JSONReader.toObjectFromFile(ItemEntity.class, dataFile);
    }

    public static CategoryEntity getCategory (String dataFile) throws Exception {
        CategoryEntity category = new CategoryEntity();
        category = JSONReader.toObjectFromFile(CategoryEntity.class, dataFile);
        return category;
    }

    public static AddressEntity getAddress(String dataFile) throws Exception {
        return JSONReader.toObjectFromFile(AddressEntity.class, dataFile);
    }
}
