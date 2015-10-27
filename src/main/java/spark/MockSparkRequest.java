package spark;


import com.github.ryber.mocks.MockHttpRequest;
import spark.route.HttpMethod;
import spark.routematch.RouteMatch;

import javax.servlet.http.Cookie;

public class MockSparkRequest extends Request {

    private final MockHttpRequest rawRequest;

    public MockSparkRequest(HttpMethod method, String path){
        this(new RouteMatch(null, path, path, null), new MockHttpRequest(method, path));
    }

    public MockSparkRequest(RouteMatch match, MockHttpRequest mockHttpResponse) {
        super(match, mockHttpResponse);
        rawRequest = mockHttpResponse;
    }

    public void addCookie(Cookie cookie){
        rawRequest.addCookie(cookie);
    }
}