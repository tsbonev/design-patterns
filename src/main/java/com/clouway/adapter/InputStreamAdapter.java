package com.clouway.adapter;

import java.io.*;

public class InputStreamAdapter {

    InputStream inputStream;

    public InputStreamAdapter(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off,len);
    }
}
