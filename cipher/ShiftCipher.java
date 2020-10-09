package encryptdecrypt.cipher;

public class ShiftCipher extends AbstractCipher {
    private final int key;

    public ShiftCipher(int key) {
        this.key = key;
    }

    @Override
    protected char encodeChar(char ch) {
        return getReversed(ch, true);
    }

    @Override
    protected char decodeChar(char ch) {
        return getReversed(ch, false);
    }

    private char getReversed(char ch, boolean encode) {
        int key = encode ? this.key : -this.key;
        ShiftResult res = shift(ch, 'a', 'z', key);
        if (res.wasShifted) {
            return res.result;
        }
        res = shift(ch, 'A', 'Z', key);
        return res.result;
    }

    static class ShiftResult {
        boolean wasShifted;
        char result;

        public ShiftResult(boolean wasShifted, char result) {
            this.wasShifted = wasShifted;
            this.result = result;
        }
    }

    private static ShiftResult shift(char ch, char start, char end, int key) {
        int diff = end - start + 1;
        if (ch >= start && ch <= end) {
            int result = ((ch + key - start) % diff);
            while (result < 0) {
                result += diff;
            }
            return new ShiftResult(true, (char) (result + start));
        }
        return new ShiftResult(false, ch);
    }
}
