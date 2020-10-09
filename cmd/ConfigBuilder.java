package encryptdecrypt.cmd;

import encryptdecrypt.cipher.Cipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ConfigBuilder {
    private Cipher.Mode mode = Cipher.Mode.ENC;
    private int key = 0;
    private String data = "";
    private String inputFilepath, outputFilepath;
    private Cipher.Algorithm algorithm = Cipher.Algorithm.SHIFT;

    public void setMode(Cipher.Mode mode) {
        this.mode = mode;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setInputFilepath(String inputFilepath) {
        this.inputFilepath = inputFilepath;
    }

    public void setOutputFilepath(String outputFilepath) {
        this.outputFilepath = outputFilepath;
    }

    public void setAlgorithm(Cipher.Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Config build() throws IOException {
        this.readInputFile();
        return new Config(this.mode, this.key, this.data, this.outputFilepath, this.algorithm);
    }

    private void readInputFile() throws IOException {
        if (!Objects.isNull(this.inputFilepath)) {
            this.data = Files.readString(Paths.get(this.inputFilepath));
        }
    }
}

