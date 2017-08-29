package basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import basic.objects.*;
import basic.objects.Error;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@RestController
public class BasicController {

    // constants
    public static final String JSON_PATH =
            "/Users/bhaskar/Development/SpringBootApp/src/main/java/basic/files/arbit.json";
    // colors
    public final String RED = "red";
    public final String YELLOW = "yellow";
    public final String GREEN = "green";

    @RequestMapping("/hello")
    public String hello() {
        return new String("Hello there!");
    }

    @RequestMapping("/group")
    public GroupReport json(@RequestParam(value="name") String groupNameString) {

        // read from .json file locally and convert to POJO
        GroupReport groupReport = new GroupReport();
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(JSON_PATH));
            System.out.println(reader.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // pick the group that is requested
        Output data = gson.fromJson(reader, Output.class);
        List<Group> groups = data.getResults();

        for (Group group : groups) {
            if (group.getName().toLowerCase().contains(groupNameString.toLowerCase())) {
                // found a matching group
                List<Metric> metrics = group.getMetricList();
                int failedMetrics = 0;
                for (Metric metric : metrics) {
                    if (metric.getMetricColor().compareTo(RED) == 0) {
                        failedMetrics++;
                    }
                }

                groupReport.setGroupName(group.getName());
                groupReport.setNumberOfFailedMetrics(failedMetrics);
                groupReport.setGroupScore(group.getGroupScore());
                groupReport.setError(null);

                return groupReport;
            }
        }

        // no such group found
        Error error = new Error();
        error.setErrorMessage("No such group found");
        error.setErrorCode(404);
        groupReport.setError(error);
        return groupReport;
    }
}