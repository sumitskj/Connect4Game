package tech.youvsyou.connect4.game.response;

public class ErrorResponse {
    private Integer errorCode;
    private String errorDescription;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer errorCode, String errorDescription, String message) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.message = message;
    }

    public ErrorResponse(Integer errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
