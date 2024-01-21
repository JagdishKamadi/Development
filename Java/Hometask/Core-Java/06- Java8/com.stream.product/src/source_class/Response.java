package source_class;

public class Response {
    private String responseBody;
    private String responseCode;
    private String responseType;

    public Response(String responseBody, String responseCode, String responseType) {
        this.responseBody = responseBody;
        this.responseCode = responseCode;
        this.responseType = responseType;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseType() {
        return responseType;
    }
}
