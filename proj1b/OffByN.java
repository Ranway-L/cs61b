public class OffByN implements CharacterComparator {
    private int n;
    public OffByN(int N) {
        n = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        /* Return true if abs(x-y) == n. */
        int diff = x - y;
        return diff == this.n || diff == -this.n;
    }
}
