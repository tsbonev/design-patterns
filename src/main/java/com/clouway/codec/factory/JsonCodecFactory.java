package com.clouway.codec.factory;

import com.clouway.codec.implementation.JsonCodec;

public class JsonCodecFactory implements CodecFactory {
    public Codec createCodec(Class c) {
        return new JsonCodec(c);
    }
}
