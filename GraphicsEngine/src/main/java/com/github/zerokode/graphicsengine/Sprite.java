package com.github.zerokode.graphicsengine;

import com.github.zerokode.coreengine.exceptions.PointOutOfBoundsException;
import com.github.zerokode.coreengine.objects.metrics.Dimension;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Sprite {

    private SpritesMap spritesMap;
    private Point2D origin;
    private Dimension dimension;

    /**
     * A Sprite is a 2D fragment of a typically larger image containing multiple sprites.
     *
     * @param spritesMap - See {@link com.github.zerokode.graphicsengine.SpritesMap}
     * @param origin     - marks the origin (top-left corner) of the sprite in the whole Sprites Map
     * @param width      - in pixels
     * @param height     - in pixels
     */
    private Sprite(SpritesMap spritesMap, Point2D origin, int width, int height) {
        this.spritesMap = spritesMap;
        this.origin = origin;
        this.dimension = new Dimension(width, height);
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
     * @param spritesMap   - the original image from which the sprite is being loaded
     * @param origin       - the "cropping area" start point  (top left corner)
     * @param spriteWidth  - in pixels
     * @param spriteHeight - in pixels
     * @return the sprite
     * @throws PointOutOfBoundsException - when trying to read bytes outside of the image boundaries
     */
    static Sprite readOne(@NonNull SpritesMap spritesMap, @NonNull Point2D origin, int spriteWidth, int spriteHeight)
            throws PointOutOfBoundsException {
        validateWidthHeightAndStartPoint(spritesMap, origin, spriteWidth, spriteHeight);
        return crop(spritesMap, origin, spriteWidth, spriteHeight);
    }

    /**
     * @param spritesMap            - the original image from which the sprite is being loaded
     * @param origin                - the "cropping area" start point  (top left corner)
     * @param individualSpriteWidth - width in pixels for each individual sprite read
     * @param spriteHeight          - height in pixels for each individual sprite read
     * @return the list of all sprites read
     * @throws PointOutOfBoundsException - when trying to read bytes outside of the image boundaries
     */
    static List<Sprite> readAllHorizontally(@NonNull SpritesMap spritesMap, @NonNull Point2D origin, int individualSpriteWidth, int spriteHeight)
            throws PointOutOfBoundsException {
        return readMultipleHorizontally(spritesMap, origin, individualSpriteWidth, spriteHeight, Integer.MAX_VALUE); // unbounded
    }

    /**
     * @param spritesMap            - the original image from which the sprite is being loaded
     * @param origin                - the "cropping area" start point  (top left corner)
     * @param individualSpriteWidth - width in pixels for each individual sprite read
     * @param spriteHeight          - height in pixels for each individual sprite read
     * @param total                 - the total number of sprites to be read
     * @return the list of all sprites read
     * @throws PointOutOfBoundsException - when trying to read bytes outside of the image boundaries
     */
    static List<Sprite> readMultipleHorizontally(@NonNull SpritesMap spritesMap, @NonNull Point2D origin, int individualSpriteWidth, int spriteHeight, int total)
            throws PointOutOfBoundsException {
        validateWidthHeightAndStartPoint(spritesMap, origin, individualSpriteWidth, spriteHeight);

        List<Sprite> sprites = new ArrayList<>();
        Point2D pivot = origin.copy(); // avoids modifying the point given in the parameters
        int counter = 0;

        while (spritesMap.canContain(pivot) && counter < total) {
            sprites.add(crop(spritesMap, pivot, individualSpriteWidth, spriteHeight));
            counter ++;
            pivot.addX(individualSpriteWidth); // move the pivot to the right 1 sprite
        }
        return sprites;
    }

    /**
     * @param spritesMap - contains the image from which we will take a fragment
     * @param origin     - start point, top left corner
     * @param width      - in pixels
     * @param height     - in pixels
     * @return a new sprite instance
     * @throws PointOutOfBoundsException - when the cropping end point (bottom-right corner) falls outside of
     *                                   the boundaries of the image.
     */
    private static Sprite crop(@NonNull SpritesMap spritesMap, @NonNull Point2D origin, int width, int height) throws PointOutOfBoundsException {
        Point2D lowerRightCorner = new Point2D(origin.getX() + width, origin.getY() + height);
        if (!spritesMap.canContain(lowerRightCorner)) {
            throw new PointOutOfBoundsException(lowerRightCorner, spritesMap.getDimension());
        }
        return new Sprite(spritesMap, origin, width, height);
    }

    /**
     * Validates that the cropping start point falls inside the boundaries of the image and that the target sprite
     * width and height are not zero (or a negative number).
     */
    private static void validateWidthHeightAndStartPoint(@NonNull SpritesMap spritesMap, @NonNull Point2D origin,
                                                         int width, int height) throws PointOutOfBoundsException {
        if (width <= 0) {
            throw new IllegalArgumentException("The resulting sprite should be at least 1 pixel wide.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("The resulting sprite should be at least 1 pixel tall.");
        }
        if (!spritesMap.getDimension().canContain(origin)) {
            throw new PointOutOfBoundsException(origin);
        }
    }

    /**
     * @return A BufferedImage representing the sprite.
     */
    public BufferedImage getImage() {
        return spritesMap.getImage().getSubimage(origin.getX(), origin.getY(), dimension.getWidth(), dimension.getHeight());
    }
}
