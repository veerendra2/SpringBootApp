package basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import basic.objects.Output;
import basic.objects.Result;

@RestController
public class BasicController {

    public static final String JSON_PATH =
            "/Users/bhaskar/Development/SpringBootApp/src/main/java/basic/files/arbit.json";

    @RequestMapping("/hello")
    public String hello() {
        return new String("Hello there!");
    }

    @RequestMapping("/metric")
    public Result json(@RequestParam(value="groupName") String groupNameString) {
        Result resultNull = new Result();
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(JSON_PATH));
            System.out.println(reader.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Output data = gson.fromJson(reader, Output.class);
        List<Result> results = data.getResults();
        for (Result result : results) {
            if (result.getName().toLowerCase().contains(groupNameString.toLowerCase())) {
                return result;
            }
        }

        return resultNull;
    }
}