package encryptdecrypt.cmd;

import encryptdecrypt.cipher.Cipher;

public class Config {
    private final Cipher.Mode mode;
    private final Cipher.Algorithm algorithm;
    private final int key;
    private final String data;
    private final String outputFilepath;

    public Config(Cipher.Mode mode, int key, String data, String outputFilepath, Cipher.Algorithm algorithm) {
        this.mode = mode;
        this.key = key;
        this.data = data;
        this.outputFilepath = outputFilepath;
        this.algorithm = algorithm;
    }

    public Cipher.Mode getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getOutputFilepath() {
        return outputFilepath;
    }

    public Cipher.Algorithm getAlgorithm() {
        return algorithm;
    }

    @Override
    public String toString() {
        return "Config{" +
                "mode=" + mode +
                ", algorithm=" + algorithm +
                ", key=" + key +
                ", data='" + data + '\'' +
                ", outputFilepath='" + outputFilepath + '\'' +
                '}';
    }
}

