package com.clouway;

import com.clouway.codec.factory.JsonCodecFactory;
import com.clouway.codec.factory.XmlCodecFactory;
import com.clouway.codec.implementation.JsonCodec;
import com.clouway.codec.implementation.XmlCodec;

public class Main {

    public static void main(String[] args) {

        JsonCodec jsonCodec = new JsonCodec(Object.class);
        XmlCodec xmlCodec = new XmlCodec(Object.class);

        JsonCodecFactory jsonFactory = new JsonCodecFactory();
        XmlCodecFactory xmlCodecFactory = new XmlCodecFactory();

        JsonCodec factoryJsonCodec = (JsonCodec) jsonFactory.createCodec(Object.class);
        XmlCodec factoryXmlCodec = (XmlCodec) xmlCodecFactory.createCodec(Object.class);


    }
}
