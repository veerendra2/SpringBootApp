package basic.objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * POJO encompassing a Group Report
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupReport {

    /* Attributes */
    private String groupName;
    private Integer numberOfFailedMetrics;
    private Float groupScore;
    private Error error;

    /* Constructor to initialize with null values */
    public GroupReport() {
        this.groupName = null;
        this.numberOfFailedMetrics = null;
        this.groupScore = null;
        this.error = null;
    }

    /* Accessors */

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getNumberOfFailedMetrics() {
        return numberOfFailedMetrics;
    }
    public void setNumberOfFailedMetrics(Integer numberOfFailedMetrics) {
        this.numberOfFailedMetrics = numberOfFailedMetrics;
    }

    public Float getGroupScore() {
        return groupScore;
    }
    public void setGroupScore(Float groupScore) {
        this.groupScore = groupScore;
    }

    public Error getError() {
        return error;
    }
    public void setError(Error error) {
        this.error = error;
    }
}
