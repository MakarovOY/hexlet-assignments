package exercise;

// BEGIN
import java.util.stream.IntStream;

public class ReversedSequence implements CharSequence {
    private String string;
    public  ReversedSequence(String string) {
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);

        }

        this.string = stringBuilder.toString();

    }

    public String getString() {
        return string;
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    @Override
    public int length() {
        char[] chars = this.getString().toCharArray();

        return chars.length;
    }

    @Override
    public char charAt(int index) {
        char[] chars = this.getString().toCharArray();


        return chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        char[] chars = this.getString().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < end; i++) {
            stringBuilder.append(chars[i]);

        }
        String subS = stringBuilder.toString();
        CharSequence chSubS = new ReversedSequence(new ReversedSequence(subS).getString());




        return chSubS;
    }

    @Override
    public String toString() {

        return this.getString();
    }


}b
// END
