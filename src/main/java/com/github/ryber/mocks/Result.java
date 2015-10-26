package com.github.ryber.mocks;

public class Result {
    private final int status;
    private final String content;
    private final String redirect;
    private final Exception thrownException;

    public Result(Exception e){
        status = 500;
        content = e.getLocalizedMessage();
        redirect = null;
        thrownException = e;
    }

    public Result(MockHttpResponse response){
        status = response.getStatus();
        content = response.getOutputString();
        redirect = response.getRedirectLocation();
        thrownException = null;
    }

    public String getContent() {
        return content;
    }

    public int getStatus() {
        return status;
    }

    public String getRedirect() {
        return redirect;
    }

    public Exception getThrownException() {
        return thrownException;
    }
}
