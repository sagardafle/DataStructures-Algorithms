import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator {
    public static void main(String args[]){
        String word = "  Sample sentence  with  spaced  words ";

        WordIterator it = new WordIterator(word);
        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());

        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());

        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());

        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());

        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());

        System.out.println(it.hasNext());
        System.out.println("word: " +it.next());
    }
}

class WordIterator implements Iterator<String> {
    private String word;
    private int iteratorIndex;

    public WordIterator(String word){
        this.word = word;
        this.iteratorIndex = 0;
    }

    @Override
    public boolean hasNext(){
        return iteratorIndex < this.word.length();
    }

    @Override
    public String next(){
        return getNextWord(iteratorIndex);
    }

    private String getNextWord(int iteratorIndex){
        int startIndex = -1;
        int endIndex = -1;

        while(this.iteratorIndex < this.word.length() && Character.isWhitespace(this.word.charAt(this.iteratorIndex))){
            this.iteratorIndex++;
        }

        //we found first non-white character
        startIndex = this.iteratorIndex;

        while(this.iteratorIndex < this.word.length() && !Character.isWhitespace(this.word.charAt(this.iteratorIndex))){
            this.iteratorIndex++;
        }

        // we found the end of word.
        endIndex = this.iteratorIndex++;

        // we never found a non-spaced word
        if(startIndex == endIndex)
            throw new NoSuchElementException("no further words found to iterate");

        return this.word.substring(startIndex, endIndex);

    }
}
