package com.clouway;

import com.clouway.codec.factory.Codec;
import com.clouway.codec.factory.CodecFactory;
import com.clouway.codec.factory.JsonCodecFactory;
import com.clouway.codec.factory.XmlCodecFactory;
import com.clouway.codec.implementation.JsonCodec;
import com.clouway.codec.implementation.XmlCodec;

public class Main {

    public enum CodecType{
        JsonCodec,
        XmlCodec,
    }

    public static void main(String[] args) {

        JsonCodec jsonCodec = new JsonCodec(Object.class);
        XmlCodec xmlCodec = new XmlCodec(Object.class);
        //Without factories

        CodecFactory jsonFactory = new JsonCodecFactory();
        CodecFactory xmlCodecFactory = new XmlCodecFactory();
        //With factories using new

        Codec factoryJsonCodec = jsonFactory.createCodec(Object.class);
        Codec factoryXmlCodec = xmlCodecFactory.createCodec(Object.class);


        CodecType type = CodecType.JsonCodec;

        CodecFactory factory;

        switch (type){
            case JsonCodec:
                factory = new JsonCodecFactory();
                break;
            default:
                factory = new XmlCodecFactory();
                break;
        }


        Codec jsonReflectionCodec = factory.createCodec(Object.class);



    }
}
