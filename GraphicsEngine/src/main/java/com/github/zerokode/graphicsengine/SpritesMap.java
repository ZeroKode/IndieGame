package com.github.zerokode.graphicsengine;

import com.github.zerokode.graphicsengine.exception.PointOutOfBoundsException;
import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;

@Getter
public class SpritesMap {

    private Dimension2D dimension;
    private BufferedImage image;

    /**
     * A SpritesMap represents a large image and metadata required to identify multiple sprites contained in it.
     * <p>
     * Loading images in java is a slow process, for this reason we should load just as few images as possible
     * and crop multiple sprites out of them.
     *
     * @param image - a java.awt.image
     */
    private SpritesMap(BufferedImage image) {
        this.image = image;
        this.dimension = new Dimension2D(image.getWidth(), image.getHeight());
    }

    /**
     * Validates the given image before creating an sprites' map.
     *
     * @param image - a java.awt.image
     * @return an object from which multiple sprites can be read
     */
    public SpritesMap create(@NonNull BufferedImage image) {
        if (image.getWidth() == 0 || image.getHeight() == 0) {
            throw new IllegalArgumentException("The image should not be zero width or height.");
        }
        return new SpritesMap(image);
    }

    /**
     * Allows you to create a sprite the same way you would crop a small fragment of a larger image.
     *
     * @param origin - the start point in a 2D selection (top left corner)
     * @param width - in pixels
     * @param height - in pixels
     * @return a new Sprite instance
     * @throws PointOutOfBoundsException when one of the points is not valid
     */
    public Sprite createSprite(@NonNull Point2D origin, int width, int height) throws PointOutOfBoundsException {
        return Sprite.create(this, origin, width, height);
    }

}
