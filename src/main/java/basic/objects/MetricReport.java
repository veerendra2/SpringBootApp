package basic.objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * POJO encompassing a Metric Report API Response
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricReport {

    /* Attributes */
    private String metricType;
    private String metricName;
    private String metricColor;
    private String relevance;
    private Error error;

    /* Constructor to initialize with null values */
    public MetricReport() {
        this.metricType = null;
        this.metricName = null;
        this.metricColor = null;
        this.relevance = null;
        this.error = null;
    }

    /* Accessors */
    public String getMetricType() {
        return metricType;
    }
    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public String getMetricName() {
        return metricName;
    }
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getMetricColor() {
        return metricColor;
    }
    public void setMetricColor(String metricColor) {
        this.metricColor = metricColor;
    }

    public String getRelevance() {
        return relevance;
    }
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public Error getError() {
        return error;
    }
    public void setError(Error error) {
        this.error = error;
    }
}
