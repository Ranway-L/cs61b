package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;

import byog.TileEngine.Tileset;
import byog.lab5.HexWorld;

import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 81;
    public static final int HEIGHT = 51;
    public String seed;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);


//    /**
//     * Fills the given 2D array of tiles with RANDOM tiles.
//     * @param tiles
//     */
//    public static void fillWithRandomTiles(TETile[][] tiles) {
//        int height = tiles[0].length;
//        int width = tiles.length;
//        for (int x = 0; x < width; x += 1) {
//            for (int y = 0; y < height; y += 1) {
//                tiles[x][y] = randomTile();
//            }
//        }
//    }
//
//    /** Picks a RANDOM tile with a 33% change of being
//     *  a wall, 33% chance of being a flower, and 33%
//     *  chance of being empty space.
//     */
//    private static TETile randomTile() {
//        int tileNum = RANDOM.nextInt(3);
//        switch (tileNum) {
//            case 0: return Tileset.WALL;
//            case 1: return Tileset.FLOWER;
//            case 2: return Tileset.NOTHING;
//            default: return Tileset.NOTHING;
//        }
//    }

    private static class Position {
        int x;
        int y;
        public Position(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class dirction {

    }

//    private void add_row
    private void add_one_room(TETile[][] world) {
//        Position p = new Position(5,5);
        Position p = new Position(RANDOM.nextInt(WIDTH),RANDOM.nextInt(HEIGHT));
        int room_width = RANDOM.nextInt(WIDTH / 4);
        int room_height = RANDOM.nextInt(HEIGHT / 4);
//        房间不越界 && 不重叠 && 不生成只有墙壁没有内部空间的房间
        if (is_out_of_range(p, room_width, room_height) && is_covered(world, p, room_width, room_height) && room_height >= 4 && room_width >= 4) {
            for (int x = 0; x < room_width; x += 1) {
                for (int y = 0; y < room_height; y += 1) {
                    if(x == 0 || x == room_width - 1 || y == 0 || y == room_height - 1) world[p.x + x][p.y + y] = Tileset.WALL;
                    else world[p.x + x][p.y + y] = Tileset.SAND;
                }
            }
        }
    }

    private void add_rooms(TETile[][] world) {
        for(int i = 0; i < 200; i++) {
            add_one_room(world);
        }

    }
    private boolean is_out_of_range(Position p, int room_width, int room_height) {
        return p.x + room_width <= WIDTH && p.y + room_height <= HEIGHT;
    }

    private boolean is_covered(TETile[][] world, Position p, int room_width, int room_height) {
        for (int x = 0; x < room_width; x += 1) {
            for (int y = 0; y < room_height; y += 1) {
                if (world[p.x + x][p.y + y] != Tileset.NOTHING) return false;
            }
        }
        return true;
    }

    private void init_world(TETile[][] world) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }
    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] newWorld = new TETile[WIDTH][HEIGHT];
        init_world(newWorld);  //Set all world tile to Tileset.NOTHING.
        //
        //TODO: Generate a world covered with rooms.
//          TODO: Generate a Room.
//              TODO: 判断房屋是否超出边界 完成
//              TODO: 判断room是否重叠 完成
//        在给定大小的地图区域内随机生成一些房间；
//        将除房间以外的区域用随机生成的迷宫填充；
//        将所有房间和迷宫通过少数节点连接起来；
//        删除不必要的迷宫死胡同，降低地图复杂度。
        add_rooms(newWorld);
        ter.renderFrame(newWorld);

    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playi+
     * ng
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().

        TETile[][] finalWorldFrame = newGame(input);
        return finalWorldFrame;
    }
    private TETile[][] newGame(String seed) {
        ter.initialize(WIDTH, HEIGHT);

        return null;
    }
}
