public class Palindrome {
    public Deque<Character> wordToDeque(String word){
       LinkedListDeque<Character> linkedListDeque = new LinkedListDeque<>();
       char[] words = word.toCharArray();
        for (int i = words.length-1; i >=0; i--) {
            linkedListDeque.addFirst(words[i]);
        }
        return  linkedListDeque;
    }

  //  public boolean isPalindrome(){

    //}

    public boolean isPalindrome(String word){
        if(word.length()<=1){
            return true;
        }
        String[] words = word.split("");
        for (int i = 0; i < words.length/2; i++) {
            if(words[i].equals(words[words.length-1-i])){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
