package spark;


import com.github.ryber.mocks.MockHttpRequest;
import spark.route.HttpMethod;
import spark.routematch.RouteMatch;

import javax.servlet.http.HttpServletRequest;

public class MockSparkRequest extends Request {
    public MockSparkRequest(HttpMethod method, String path){
        this(new RouteMatch(null, path, path, null), new MockHttpRequest(method, path));
    }

    public MockSparkRequest(RouteMatch match, HttpServletRequest mockHttpResponse) {
        super(match, mockHttpResponse);
    }
}