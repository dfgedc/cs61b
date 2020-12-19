import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator {
   // private char c= '
    /**
     * Returns true if characters are equal by the rules of the implementing class.
     *
     * @param x
     * @param y
     */
    @Override
    public boolean equalChars(char x, char y) {
        if(x==y){
            return true;
        }
        return false;
    }
    @Test
    public void TestOffByOne(){
            char x = 'a';
            char x1 = 'b';
            char x2 = 'c';
            char x3 = 'd';
            char x4 = 'a';
            char x5 = 'c';
        assertFalse(equalChars(x,x1));
    }
}
