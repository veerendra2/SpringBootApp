package basic.objects;

/*
 * POJO encompassing an API error
 */
public class Error {

    /* Attributes */
    private Integer errorCode;
    private String errorMessage;

    /* Accessors */

    public Integer getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
