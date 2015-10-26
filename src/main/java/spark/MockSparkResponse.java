package spark;


import com.github.ryber.mocks.MockHttpResponse;

import javax.servlet.http.HttpServletResponse;

public class MockSparkResponse extends Response {
    public MockSparkResponse(){
        this(new MockHttpResponse());
    }

    public MockSparkResponse(HttpServletResponse mockHttpResponse) {
        super(mockHttpResponse);
    }
}
