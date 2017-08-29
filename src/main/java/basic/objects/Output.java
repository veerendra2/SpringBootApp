package basic.objects;

import java.util.List;

public class Output {

	/* Attributes */
	String canaryId;
	String health;
	String canaryFinalScore;
	List<Group> results;

	/* Accessors */
	public String getCanaryId() {
		return canaryId;
	}
	public String getHealth() {
		return health;
	}
	public String getCanaryFinalScore() {
		return canaryFinalScore;
	}
	public List<Group> getResults() {
		return results;
	}
}