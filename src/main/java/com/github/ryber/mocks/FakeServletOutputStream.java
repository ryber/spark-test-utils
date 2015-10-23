package com.github.ryber.mocks;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

public class FakeServletOutputStream extends ServletOutputStream {

    private StringBuilder builder;

    public FakeServletOutputStream() {
        this.builder = new StringBuilder();
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void write(int b) throws IOException {
        this.builder.append((char)b);

    }

    public StringBuilder getStringBuilder() {
        return this.builder;
    }
}
