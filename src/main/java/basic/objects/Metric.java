package basic.objects;

/*
 * POJO encompassing a Metric
 */
public class Metric {

    /* Attributes */
    private String metricType;
    private String metricName;
    private String metricScore;
    private String metricColor;
    private String relevance;
    private String metricError;

    /* Accessors */
    public String getMetricType() {
        return metricType;
    }
    public String getMetricName() {
        return metricName;
    }
    public String getMetricScore() {
        return metricScore;
    }
    public String getMetricColor() {
        return metricColor;
    }
    public String getRelevance() {
        return relevance;
    }
    public String getMetricError() {
        return metricError;
    }
}
