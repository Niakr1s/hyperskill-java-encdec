package encryptdecrypt.cipher;

public interface Cipher {
    enum Mode {ENC, DEC,}

    enum Algorithm {SHIFT, UNICODE,}

    String encode(String str);
    String decode(String str);

    default String doWork(Mode mode, String str) {
        switch (mode) {
            case DEC:
                return decode(str);
            case ENC:
                return encode(str);
        }
        return str;
    }

    class Config {
        private final Algorithm algorithm;
        private final int key;

        public Config(Algorithm algorithm, int key) {
            this.algorithm = algorithm;
            this.key = key;
        }

        public Config(Algorithm algorithm) {
            this(algorithm, 0);
        }
    }

    static Cipher getInstance(Config config) {
        switch (config.algorithm) {
            case SHIFT:
                return new ShiftCipher(config.key);
            case UNICODE:
                return new UnicodeCipher(config.key);
        }
        throw new RuntimeException("never");
    }
}
