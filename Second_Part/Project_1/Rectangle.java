import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rectangle extends Rectangle2D implements Shape, Serializable {

    /**
     * Sets the location and size of this {@code Rectangle2D}
     * to the specified {@code double} values.
     *
     * @param x the X coordinate of the upper-left corner
     *          of this {@code Rectangle2D}
     * @param y the Y coordinate of the upper-left corner
     *          of this {@code Rectangle2D}
     * @param w the width of this {@code Rectangle2D}
     * @param h the height of this {@code Rectangle2D}
     * @since 1.2
     */
    @Override
    public void setRect(double x, double y, double w, double h) {

    }

    /**
     * Determines where the specified coordinates lie with respect
     * to this {@code Rectangle2D}.
     * This method computes a binary OR of the appropriate mask values
     * indicating, for each side of this {@code Rectangle2D},
     * whether or not the specified coordinates are on the same side
     * of the edge as the rest of this {@code Rectangle2D}.
     *
     * @param x the specified X coordinate
     * @param y the specified Y coordinate
     * @return the logical OR of all appropriate out codes.
     * @see #OUT_LEFT
     * @see #OUT_TOP
     * @see #OUT_RIGHT
     * @see #OUT_BOTTOM
     * @since 1.2
     */
    @Override
    public int outcode(double x, double y) {
        return 0;
    }

    /**
     * Returns a new {@code Rectangle2D} object representing the
     * intersection of this {@code Rectangle2D} with the specified
     * {@code Rectangle2D}.
     *
     * @param r the {@code Rectangle2D} to be intersected with
     *          this {@code Rectangle2D}
     * @return the largest {@code Rectangle2D} contained in both
     * the specified {@code Rectangle2D} and in this
     * {@code Rectangle2D}.
     * @since 1.2
     */
    @Override
    public Rectangle2D createIntersection(Rectangle2D r) {
        return null;
    }

    /**
     * Returns a new {@code Rectangle2D} object representing the
     * union of this {@code Rectangle2D} with the specified
     * {@code Rectangle2D}.
     *
     * @param r the {@code Rectangle2D} to be combined with
     *          this {@code Rectangle2D}
     * @return the smallest {@code Rectangle2D} containing both
     * the specified {@code Rectangle2D} and this
     * {@code Rectangle2D}.
     * @since 1.2
     */
    @Override
    public Rectangle2D createUnion(Rectangle2D r) {
        return null;
    }

    /**
     * Returns the X coordinate of the upper-left corner of
     * the framing rectangle in {@code double} precision.
     *
     * @return the X coordinate of the upper-left corner of
     * the framing rectangle.
     * @since 1.2
     */
    @Override
    public double getX() {
        return 0;
    }

    /**
     * Returns the Y coordinate of the upper-left corner of
     * the framing rectangle in {@code double} precision.
     *
     * @return the Y coordinate of the upper-left corner of
     * the framing rectangle.
     * @since 1.2
     */
    @Override
    public double getY() {
        return 0;
    }

    /**
     * Returns the width of the framing rectangle in
     * {@code double} precision.
     *
     * @return the width of the framing rectangle.
     * @since 1.2
     */
    @Override
    public double getWidth() {
        return 0;
    }

    /**
     * Returns the height of the framing rectangle
     * in {@code double} precision.
     *
     * @return the height of the framing rectangle.
     * @since 1.2
     */
    @Override
    public double getHeight() {
        return 0;
    }

    /**
     * Determines whether the {@code RectangularShape} is empty.
     * When the {@code RectangularShape} is empty, it encloses no
     * area.
     *
     * @return {@code true} if the {@code RectangularShape} is empty;
     * {@code false} otherwise.
     * @since 1.2
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
}