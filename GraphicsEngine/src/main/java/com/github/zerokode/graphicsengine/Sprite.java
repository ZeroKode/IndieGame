package com.github.zerokode.graphicsengine;

import com.github.zerokode.graphicsengine.exception.PointOutOfBoundsException;
import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;

@Getter
public class Sprite {

    private SpritesMap spritesMap;
    private Point2D origin;
    private int width, height;

    /**
     * A Sprite is a 2D fragment of a typically larger image containing multiple sprites.
     *
     * @param spritesMap
     * @param origin
     * @param width      - in pixels
     * @param height     - in pixels
     */
    private Sprite(SpritesMap spritesMap, Point2D origin, int width, int height) {
        this.spritesMap = spritesMap;
        this.origin = origin;
        this.width = width;
        this.height = height;
    }

    /**
     * Normally you would create a SpritesMap object first and then get multiple Sprites from it.
     * Creating a single sprite from a single image, although possible, is discouraged since
     * it consumes too much time to load individual images.
     * <p>
     * See also {@link com.github.zerokode.graphicsengine.SpritesMap}
     * <p>
     * IMPORTANT: All sprites keep a reference to the original Sprites' Map and this is actually much less
     * expensive than copying the bytes that represent the cropped image in each sprite. The reason is that
     * Java doesn't create a new SpritesMap object for each sprite, it just "points" to the position in memory
     * in which that object is located. This address is just 4 bytes long in 32-bit systems and 8 bytes long
     * in 64-bit systems.
     *
     * @param spritesMap - the original image from which the sprite is being loaded
     * @param origin     - the "cropping area" start point  (top left corner)
     * @param width      - sprite's width in pixels
     * @param height     - sprite's height in pixels
     * @return
     * @throws PointOutOfBoundsException
     */
    public static Sprite create(@NonNull SpritesMap spritesMap, @NonNull Point2D origin, int width, int height)
            throws PointOutOfBoundsException {
        if (width <= 0) {
            throw new IllegalArgumentException("The resulting sprite should be at least 1 pixel wide.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("The resulting sprite should be at least 1 pixel tall.");
        }
        if (!spritesMap.getDimension().canContain(origin)) {
            throw new PointOutOfBoundsException(origin);
        }
        // The "cropping area" end point.
        Point2D to = Point2D.create(origin.getX() + width, origin.getY() + height);
        if (!spritesMap.getDimension().canContain(to)) {
            throw new PointOutOfBoundsException(to);
        }
        return new Sprite(spritesMap, origin, width, height);
    }

    /**
     * @return A BufferedImage representing the sprite.
     */
    public BufferedImage getImage() {
        return spritesMap.getImage().getSubimage(origin.getX(), origin.getY(), width, height);
    }
}
