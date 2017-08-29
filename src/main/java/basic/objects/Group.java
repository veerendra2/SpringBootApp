package basic.objects;

import java.util.List;

/*
 * POJO encompassing a Group
 */
public class Group {

    /* Attributes */
    private String name;
    private String groupColor;
    private String groupRelevance;
    private float groupScore;
    private String groupSuccessMetricCount;
    private List<Metric> metricList;

    /* Accessors */

    public String getName() {
        return name;
    }
    public String getGroupColor() {
        return groupColor;
    }
    public String getGroupRelevance() {
        return groupRelevance;
    }
    public float getGroupScore() {
        return groupScore;
    }
    public String getGroupSuccessMetricCount() {
        return groupSuccessMetricCount;
    }
    public List<Metric> getMetricList() {
        return metricList;
    }
}
