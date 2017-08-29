package basic.objects;

/*
 * POJO encompassing a Group Report
 */
public class GroupReport {

    /* Attributes */
    private String groupName;
    private int numberOfFailedMetrics;
    private float groupScore;
    // private Error error;

    /* Accessors */

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getNumberOfFailedMetrics() {
        return numberOfFailedMetrics;
    }
    public void setNumberOfFailedMetrics(int numberOfFailedMetrics) {
        this.numberOfFailedMetrics = numberOfFailedMetrics;
    }

    public float getGroupScore() {
        return groupScore;
    }
    public void setGroupScore(float groupScore) {
        this.groupScore = groupScore;
    }
}
