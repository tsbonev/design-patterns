package com.clouway.codec.factory;

import com.clouway.codec.implementation.XmlCodec;

public class XmlCodecFactory implements CodecFactory {
    public Codec createCodec(Class c) {
        return new XmlCodec(c);
    }
}
