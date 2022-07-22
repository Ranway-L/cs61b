import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
       /* For single parameter Test.*/
        String a = "asddsa";
        String b = "asddas";
        String singleWord = "a";
        String noWord = "";
        String c = "FASF626+DFA6F";
        assertTrue(palindrome.isPalindrome(a));
        assertFalse(palindrome.isPalindrome(b));
        assertTrue(palindrome.isPalindrome(singleWord));
        assertTrue(palindrome.isPalindrome(noWord));
        assertFalse(palindrome.isPalindrome(c));

        /* For two parameters Test.*/
        CharacterComparator offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("asddsa",offByOne));
        assertTrue(palindrome.isPalindrome("flake",offByOne));

    }
}
