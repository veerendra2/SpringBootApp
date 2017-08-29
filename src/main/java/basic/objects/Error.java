package basic.objects;

/*
 * POJO encompassing an API error
 */
public class Error {

    /* Attributes */
    private Integer errorCode;
    private String errorMessage;

    /* Accessors */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
