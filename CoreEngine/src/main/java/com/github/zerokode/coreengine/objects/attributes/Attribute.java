package com.github.zerokode.coreengine.objects.attributes;

import lombok.Getter;

@Getter
public abstract class Attribute {

    /**
     * Two attribute instances should be considered equal in order to avoid adding the same
     * attribute twice to a single GameObject.
     *
     * @param obj - another attribute typically.
     * @return true when both Attributes belong to the very same implementing class.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Attribute)) {
            return false;
        }
        return isSameType(((Attribute) obj).getClass());
    }

    /**
     * The hash code of two Attribute objects of the very same implementing class should be the same.
     *
     * @return the hash code of the canonical class name of this Attribute instance.
     */
    @Override
    public int hashCode() {
        return this.getClass().getCanonicalName().hashCode();
    }

    public boolean isSameType(Class<? extends Attribute> clazz) {
        return clazz.getCanonicalName().equals(this.getClass().getCanonicalName());
    }
}
