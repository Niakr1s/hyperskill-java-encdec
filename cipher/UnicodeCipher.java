package encryptdecrypt.cipher;

public class UnicodeCipher extends AbstractCipher {
    private final int key;

    public UnicodeCipher(int key) {
        this.key = key;
    }

    protected char encodeChar(char ch) {
        return (char)(ch + key);
    }

    protected char decodeChar(char ch) {
        return (char)(ch - key);
    }
}
