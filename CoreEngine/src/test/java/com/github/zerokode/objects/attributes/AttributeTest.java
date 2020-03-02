package com.github.zerokode.objects.attributes;

import com.github.zerokode.coreengine.objects.attributes.Breakable;
import com.github.zerokode.coreengine.objects.attributes.Flying;
import com.github.zerokode.coreengine.objects.attributes.Movable;
import com.github.zerokode.coreengine.objects.attributes.Walker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Attributes should be overwritten/replaced to avoid adding two or more attributes of the same type
 * to the same GameObject. For that purpose we are overriding the equals and hasCode methods.
 */
public class AttributeTest {

    @Test
    public void testTwoAttributesOfTheSameClassEqual() {
        Breakable breakableA = new Breakable();
        Breakable breakableB = new Breakable();
        Assert.assertEquals(breakableA, breakableB);
        Assert.assertEquals(breakableA.hashCode(), breakableB.hashCode());
    }

    @Test
    public void testTwoAttributesOfDifferentClassDiffer() {
        Breakable breakable = new Breakable();
        Movable movable = new Movable();
        Assert.assertNotEquals(breakable, movable);
        Assert.assertNotEquals(breakable.hashCode(), movable.hashCode());
    }

    @Test
    public void testTwoAttributesWithSameParentDiffer() {
        Walker walker = new Walker();
        Flying flying = new Flying();
        Assert.assertNotEquals(walker, flying);
        Assert.assertNotEquals(walker.hashCode(), flying.hashCode());
    }

    @Test
    public void testTwoAttributesDifferRegardlessInheritance() {
        Walker walker = new Walker();
        Movable movable = new Movable();
        Assert.assertNotEquals(walker, movable);
        Assert.assertNotEquals(walker.hashCode(), movable.hashCode());
    }

    @Test
    public void testTwoAttributesOfTheSameClassButDifferentValuesEqual() {
        Movable movable = new Movable();
        movable.setSpeed(1.34f);

        Movable movableB = new Movable();
        movableB.setSpeed(0.54f);

        Assert.assertEquals(movableB, movable);
        Assert.assertEquals(movableB.hashCode(), movable.hashCode());
    }

}