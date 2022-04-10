import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class Json {
    final private static Type listType = new TypeToken<List<Employee>>() {
    }.getType();

    public static void writeEmployeetoJson(List<Employee> list, String JsonFile) throws IOException {
        String json = listToJson(list);
        try (Writer file = new FileWriter(JsonFile)) {
            file.write(json);
            file.flush();
        }
    }

    private static String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(list, listType);
    }
}
