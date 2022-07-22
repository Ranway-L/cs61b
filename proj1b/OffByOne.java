public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        /* Return true if abs(x-y) == 1. */
        int diff = x - y;
        return diff == 1 || diff == -1;
    }

}
