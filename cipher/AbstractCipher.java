package encryptdecrypt.cipher;

import java.util.function.Function;

public abstract class AbstractCipher implements Cipher {
    private String transform(String str, Function<Character, Character> transformChar) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ch = transformChar.apply(ch);
            res.append(ch);
        }

        return res.toString();
    }

    @Override
    public String encode(String str) {
        return transform(str, this::encodeChar);
    }

    abstract protected char encodeChar(char ch);

    @Override
    public String decode(String str) {
        return transform(str, this::decodeChar);
    }

    abstract protected char decodeChar(char ch);
}
