package com.github.ryber.mocks;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

public class MockHttpResponse implements HttpServletResponse {

    private int status = 200;

    private FakeServletOutputStream fakeStream = new FakeServletOutputStream();
    private String redirectLocation;
    private Multimap<String,String> headers = HashMultimap.create();


    public String getOutputString()  {
        return fakeStream.getStringBuilder().toString();
    }

    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public boolean containsHeader(String name) {
        return false;
    }

    @Override
    public String encodeURL(String url) {
        return null;
    }

    @Override
    public String encodeRedirectURL(String url) {
        return null;
    }

    @Override
    public String encodeUrl(String url) {
        return null;
    }

    @Override
    public String encodeRedirectUrl(String url) {
        return null;
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        status = sc;
    }

    @Override
    public void sendError(int sc) throws IOException {
        status = sc;
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        status = 302;
        redirectLocation = location;
    }

    @Override
    public void setDateHeader(String name, long date) {
        headers.replaceValues(name, Arrays.asList(String.valueOf(date)));
    }

    @Override
    public void addDateHeader(String name, long date) {
        headers.put(name, String.valueOf(date));
    }

    @Override
    public void setHeader(String name, String value) {
        headers.replaceValues(name, Arrays.asList(value));
    }

    @Override
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    @Override
    public void setIntHeader(String name, int value) {

    }

    @Override
    public void addIntHeader(String name, int value) {

    }

    @Override
    public void setStatus(int sc) {
        status = sc;
    }

    @Override
    public void setStatus(int sc, String sm) {
        status = sc;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return fakeStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    public void setContentLengthLong(long l) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    public int getStatus(){
        return status;
    }

    @Override
    public String getHeader(String s) {
        return headers.get(s).stream().findFirst().orElse(null);
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return headers.get(s);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return headers.keySet();
    }

    public String getRedirectLocation(){
        return redirectLocation;
    }
}
