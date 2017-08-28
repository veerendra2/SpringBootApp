package basic;

public class Metric {

    private final String metricColor;
    private final String relevance;
    private final String metricType;

    public Metric(String metricColor, String relevance, String metricType) {
        this.metricColor = metricColor;
        this.relevance = relevance;
        this.metricType = metricType;
    }

    public String getMetricColor() {
        return metricColor;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getMetricType() {
        return metricType;
    }
}