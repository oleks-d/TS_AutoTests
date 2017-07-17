package utils;

import entities.ItemEntity;
import entities.UserEntity;

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
}
