package http.response;

public class RedirectResponse extends Response{
    private String target;

    public RedirectResponse(String target) {
        this.target = target;
    }

    @Override
    public String getResponseString() {
        String response = "HTTP/1.1 301 Redirect\r\nLocation:" + this.target + "\r\n\r\n";
        return response;
    }
}
