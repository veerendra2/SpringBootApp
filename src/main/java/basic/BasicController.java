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
    public GroupReport returnGroupReport(@RequestParam(value="name") String groupNameString) {

        // read from .json file locally and convert to POJO
        GroupReport groupReport = new GroupReport();
        Output data = convertJson(JSON_PATH);
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

                return groupReport;
            }
        }

        // no such group found, return respective error
        Error error = new Error();
        error.setErrorMessage("No such group found");
        error.setErrorCode(404);
        groupReport.setError(error);

        return groupReport;
    }

    @RequestMapping("/metric")
    public MetricReport returnMetricReport(@RequestParam(value="name") String metricName) {

        // read from .json file locally and convert to POJO
        MetricReport metricReport = new MetricReport();
        Output data = convertJson(JSON_PATH);
        List<Group> groups = data.getResults();

        for (Group group : groups) {
            List<Metric> metrics = group.getMetricList();
            for (Metric metric : metrics) {
                if (metric.getMetricName().compareTo(metricName) == 0) {
                    // return metric;

                    // found metric we are looking for
                    metricReport.setMetricType(metric.getMetricType());
                    metricReport.setMetricName(metric.getMetricName());
                    metricReport.setMetricColor(metric.getMetricColor());
                    metricReport.setRelevance(metric.getRelevance());

                    return metricReport;
                }
            }
        }

        // no such metric found
        Error error = new Error();
        error.setErrorMessage("No such metric found");
        error.setErrorCode(404);
        metricReport.setError(error);

        return metricReport;
    }

    /* Helper method to convert local JSON to POJO */
    private Output convertJson(String filePath) {

        // read from .json file locally and convert to POJO
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(filePath));
            System.out.println(reader.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // pick the group that is requested
        return gson.fromJson(reader, Output.class);
    }
}