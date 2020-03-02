package com.github.zerokode.exceptions;

import com.github.zerokode.coreengine.objects.attributes.Attribute;

public class AttributeNotFoundException extends Exception {

    public AttributeNotFoundException(Class<? extends Attribute> clazz){
        super("No attribute found with type: " + clazz.getName());
    }
}
