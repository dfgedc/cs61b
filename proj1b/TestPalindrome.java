import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testPalindrome(){
       String word = "noon";
       String word1 = "alllla";
       String word2 = "123321";
       String word3 = "asdfg";
       boolean  b = palindrome.isPalindrome(word);
       boolean b1 = palindrome.isPalindrome(word1);
       boolean b2 = palindrome.isPalindrome(word2);
       boolean b3 = palindrome.isPalindrome(word3);
       assertEquals(true,b1);
       assertEquals(true,b);
       assertEquals(true,b2);
       assertEquals(false,b3);
       assertFalse(palindrome.isPalindrome("cat"));
    //   assertEquals(true,);
    }
    //Uncomment this class once you've created your Palindrome class. */
}
