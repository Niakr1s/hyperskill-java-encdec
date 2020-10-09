package encryptdecrypt.cmd;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public interface Output {
    void write(String str);

    static Output getInstance(String outputFilePath) {
        if (Objects.isNull(outputFilePath)) {
            return new StdOut();
        } else {
            return new FileOut(outputFilePath);
        }
    }
}

class StdOut implements Output {
    @Override
    public void write(String str) {
        System.out.println(str);
    }
}

class FileOut implements Output {
    private final String outputFilepath;

    public FileOut(String outputFilepath) {
        this.outputFilepath = outputFilepath;
    }

    @Override
    public void write(String str) {
        try {
            Files.writeString(Paths.get(this.outputFilepath), str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}