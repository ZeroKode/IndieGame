package com.github.zerokode.coreengine.objects;

import com.github.zerokode.coreengine.exceptions.AttributeNotFoundException;
import com.github.zerokode.coreengine.objects.attributes.Attribute;
import com.github.zerokode.coreengine.objects.attributes.Drawable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

/**
 * Everything that appears on screen is a GameObject.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameObject {

    private HashSet<Attribute> attributes = new HashSet<>();

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
    }

    public int getWidthInMm() {
        Attribute found = findAttribute(Drawable.class, new Drawable(0, 0));
        return ((Drawable)found).getWidthInMm();
    }

    public int getHeightInMm() {
        Attribute found = findAttribute(Drawable.class, new Drawable(0, 0));
        return ((Drawable)found).getHeightInMm();
    }

    /**
     * Looks for an attribute of the given type since there can only be one or none.
     * @param clazz - the type of the Attribute we are looking for
     * @param defaultValue
     * @return the attribute found or the default value.
     */
    private Attribute findAttribute(Class <? extends Attribute> clazz, Attribute defaultValue){
        try{
            return getAttribute(clazz);
        }catch (AttributeNotFoundException e){
            return defaultValue;
        }
    }

    /**
     * Looks for an attribute of the given type since there can only be one or none.
     * @param clazz - the type of the Attribute we are looking for
     * @return
     * @throws AttributeNotFoundException - when there are no attributes of the given type
     */
    private Attribute getAttribute(Class <? extends Attribute> clazz) throws AttributeNotFoundException {
        for (Attribute attribute : attributes){
            if (attribute.isSameType(clazz)){
                return attribute;
            }
        }
        throw new AttributeNotFoundException(clazz);
    }

}
