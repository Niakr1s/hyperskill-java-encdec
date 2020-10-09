package encryptdecrypt;

import encryptdecrypt.cmd.Config;
import encryptdecrypt.cmd.Input;
import encryptdecrypt.cmd.InvalidArgsException;
import encryptdecrypt.cmd.Output;
import encryptdecrypt.cipher.Cipher;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidArgsException, IOException {
        Config config = Input.parseArgs(args);

        Cipher cipher = Cipher.getInstance(new Cipher.Config(config.getAlgorithm(), config.getKey()));

        String res = cipher.doWork(config.getMode(), config.getData());

        Output out = Output.getInstance(config.getOutputFilepath());
        out.write(res);
    }
}