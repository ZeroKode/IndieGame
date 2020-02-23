package com.github.zerokode.graphicsengine;

import com.github.zerokode.graphicsengine.exception.PointOutOfBoundsException;
import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;
import java.util.List;

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
     * Short-hand for spritesMap.getDimension().canContain(point)
     *
     * @param point - a point in the image
     * @return false when the point falls outside of the boundaries of the image
     */
    public boolean canContain(Point2D point) {
        return dimension.canContain(point);
    }

    /**
     * Allows you to read a sprite from the whole sprite's map.
     *
     * @param origin       - the start point in a 2D selection (top left corner)
     * @param spriteWidth  - in pixels
     * @param spriteHeight - in pixels
     * @return a new Sprite instance
     * @throws PointOutOfBoundsException when one of the points is not valid
     */
    public Sprite readOne(@NonNull Point2D origin, int spriteWidth, int spriteHeight) throws PointOutOfBoundsException {
        return Sprite.readOne(this, origin, spriteWidth, spriteHeight);
    }

    /**
     * Reads all the sprites it can horizontally. Each sprite will have the same width and height.
     * We assume there's a zero-pixels gap between individual sprites.
     * When using this method make sure that the width of the sprite's map is a multiple of the width of each sprite.
     * <p>
     * Example 1: When the sprite's map is 1000 pixels wide and the individualSpriteWidth is 100px then 10 sprites will be returned.
     * <p>
     * Example 2: When the sprite's map is 1024 pixels wide and the individualSpriteWidth is 100px an exception will be thrown
     * when trying to read the sprite #11. To avoid this exception you can use readMultipleHorizontally(...) with a total of 10.
     *
     * @param origin                - the "cropping area" start point  (top left corner)
     * @param individualSpriteWidth - width in pixels for each individual sprite read
     * @param spriteHeight          - height in pixels for each individual sprite read
     * @return the list of all sprites read
     * @throws PointOutOfBoundsException - when trying to read bytes outside of the image boundaries
     */
    public List<Sprite> readAllHorizontally(@NonNull Point2D origin, int individualSpriteWidth, int spriteHeight) throws PointOutOfBoundsException {
        return Sprite.readAllHorizontally(this, origin, individualSpriteWidth, spriteHeight);
    }

    /**
     * Reads N-sprites horizontally. Each sprite will have the same width and height.
     * We assume there's a zero-pixels gap between individual sprites.
     *
     * @param origin                - the "cropping area" start point  (top left corner)
     * @param individualSpriteWidth - width in pixels for each individual sprite read
     * @param spriteHeight          - height in pixels for each individual sprite read
     * @param total                 - the total number of sprites to be read
     * @return the list of all sprites read
     * @throws PointOutOfBoundsException - when trying to read bytes outside of the image boundaries
     */
    public List<Sprite> readMultipleHorizontally(@NonNull Point2D origin, int individualSpriteWidth, int spriteHeight, int total) throws PointOutOfBoundsException {
        return Sprite.readMultipleHorizontally(this, origin, individualSpriteWidth, spriteHeight, total);
    }

}
