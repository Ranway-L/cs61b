package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);
    private static class Position {
        int x;
        int y;
        public Position(int x,int y) {
            this.x = x;
            this.y = y;
        }
}

    private static void generate_one_line(TETile[][] world, Position p, int length, TETile t) {
        for(int xi = 0; xi< length; xi++) {
            int xx = p.x + xi;
            int yy = p.y;
            world[xx][yy] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }

    }

    private static int change_xStart(int length, int yi) {
        if (yi <= length) return -yi;
        return yi - length;
    }

    private static int line_width(int length, int yi) {
        int res;
        if (yi <= length) res = 2 * yi;
        res = 2 * (yi - length);
        return length + 2 * res;

    }
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        for(int yi = 0; yi <2 * s; yi++) {
            int yStart = p.y + yi;
            int xStart = p.x + change_xStart(s, yi);
            Position start = new Position(xStart, yStart);
            int width = line_width(s, yi);
            generate_one_line(world, start, width, t);
        }
    }
}
