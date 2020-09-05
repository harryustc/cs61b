import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('a', 'y'));
        assertTrue(offByOne.equalChars('w', 'x'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('x', 'y'));
    }

    @Test
    public void testIsPalindrome() {
        Palindrome palindrom = new Palindrome();
        assertFalse(palindrom.isPalindrome("woshinidabaow"));
        assertTrue(palindrom.isPalindrome("shanghaiiahgnahs"));
        assertTrue(palindrom.isPalindrome(""));
        assertTrue(palindrom.isPalindrome("s"));

        Palindrome palindrome = new Palindrome();
        assertFalse(palindrome.isPalindrome("woshinidabaow", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("s", offByOne));
    }
}
