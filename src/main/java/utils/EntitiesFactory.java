package utils;

import entities.UserEntity;

import java.io.File;

/**
 * Created by odiachuk on 13.07.17.
 */
public class EntitiesFactory {

    public static UserEntity getUser(String userFile) throws Exception {
        UserEntity user = new UserEntity();
        user = JSONReader.toObjectFromFile(UserEntity.class, userFile);
        return user;
    }

}
