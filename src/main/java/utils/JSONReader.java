package utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import entities.BaseEntity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by odiachuk on 13.07.17.
 *
 *
 * Interaction with JSON files
 *
 *
 */

public class JSONReader {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static <T extends BaseEntity> T toObjectFromFile(Class<T> classOfT, String file) throws Exception{

        try {
            return gson.fromJson(new JsonReader(new FileReader(new File(file))), classOfT);
        } catch (FileNotFoundException e) {
            throw new Exception("File was not found " + file);
        }
    }

    public static <T extends BaseEntity> T toObjectFromJson(Class<T> classOfT, String jsonString) {
        return gson.fromJson(jsonString, classOfT);
    }

    public static final <T extends BaseEntity> List<T> toObjectListFromJson(final Class<T[]> clazz, final String json)
    {
        final T[] jsonToObject = new Gson().fromJson(json, clazz);
        List<T> result = new ArrayList<>(Arrays.asList(jsonToObject));
        result.removeAll(Collections.singleton(null));
        return result;
    }

    public static final <T extends BaseEntity> List<T> toObjectListFromFile(final Class<T[]> clazz, final File file) throws IOException {
        T[] jsonToObject = null;
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls()
                .create();
        try {
            jsonToObject = gson.fromJson(new JsonReader(new FileReader(file)), clazz);
        } catch (JsonSyntaxException e){
            List<String> objects = FileUtils.readLines(file);
            objects.removeAll(Collections.singleton(""));
            String jsonAsString = "["+Joiner.on(",").join(objects)+"]";
            jsonToObject = gson.fromJson(jsonAsString, clazz);
        }
        List<T> result = new ArrayList<>(Arrays.asList(jsonToObject));
        result.removeAll(Collections.singleton(null));
        return result;
    }

    public static final List<HashMap<String,String>> toHashMapListFromFile (File file) throws IOException {
        ArrayList<HashMap<String,String>> jsonToObject = null;
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<HashMap<String,String>>>(){}.getType();

        try {
            jsonToObject = gson.fromJson(new JsonReader(new FileReader(file)), type);
        } catch (JsonSyntaxException e) {
            List<String> objects = FileUtils.readLines(file);
            objects.removeAll(Collections.singleton(""));
            String jsonAsString = "[" + Joiner.on(",").join(objects) + "]";
            jsonToObject = gson.fromJson(jsonAsString, type);
        }
        return jsonToObject;
    }

    public static <T extends BaseEntity> String toJson(T object, String... omittedFields) {
        JsonObject jsonObject = gson.toJsonTree(object).getAsJsonObject();
        for (String str : omittedFields) {
            jsonObject.remove(str);
        }
        return jsonObject.toString();
    }

    public static <T extends BaseEntity> String toJson(List<T> objects) {
        List<String> jsonList = Lists.transform(objects, object -> gson.toJsonTree(object).getAsJsonObject().toString());
        String jsonAsString = Joiner.on(",").join(jsonList);
        return "["+jsonAsString+"]";
    }


    public static String objectToJson( BaseEntity objects)
    {
        Gson gson = new GsonBuilder().create();
        String returnString = gson.toJson(objects);

        return returnString;
    }
}

