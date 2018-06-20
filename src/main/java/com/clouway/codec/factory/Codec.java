package com.clouway.codec.factory;

import java.io.File;

public interface Codec {

    Object parseFile(File file);
    File parseObject(Object object);

}
