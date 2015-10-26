package com.github.ryber.mocks;

import spark.route.HttpMethod;
import spark.route.RouteMatcherFactory;
import spark.webserver.MatcherFilter;

import javax.servlet.http.Cookie;

public class FakeAppServer {

    public static Result exec(HttpMethod method, String path){
        return exec(method, path, null, null);
    }

    public static Result exec(HttpMethod method, String path, FormVars form){
        return exec(method, path, form, null);
    }

    public static Result exec(HttpMethod method, String path, FormVars form, Cookie[] cookies){
        MatcherFilter matcherFilter = new MatcherFilter(RouteMatcherFactory.get(), false, false);
        matcherFilter.init(null);

        MockHttpRequest request = new MockHttpRequest(method, path, form, cookies);


        MockHttpResponse response = new MockHttpResponse();
        try {
            matcherFilter.doFilter(request, response, null);
        } catch (Exception e) {
            return new Result(e);
        }

        return new Result(response);
    }



}
