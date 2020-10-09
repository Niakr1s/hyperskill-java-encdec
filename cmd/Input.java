package encryptdecrypt.cmd;

import encryptdecrypt.cipher.Cipher;

import java.io.IOException;

public class Input {
    static public Config parseArgs(String[] flags) throws InvalidArgsException, IOException {
        ConfigBuilder config = new ConfigBuilder();
        for (int i = 0; i < flags.length - 1; i++) {
            String next = flags[i + 1];
            switch (flags[i]) {
                case "-mode": {
                    if (next.equals("dec")) {
                        config.setMode(Cipher.Mode.DEC);
                    }
                    break;
                }
                case "-key": {
                    try {
                        config.setKey(Integer.parseInt(next));
                    } catch (Exception ignored) {
                        throw new InvalidArgsException();
                    }
                    break;
                }
                case "-data": {
                    config.setData(next);
                    break;
                }
                case "-out": {
                    config.setOutputFilepath(next);
                    break;
                }
                case "-in": {
                    config.setInputFilepath(next);
                    break;
                }
                case "-alg": {
                    switch (next) {
                        case "unicode": {
                            config.setAlgorithm(Cipher.Algorithm.UNICODE);
                            break;
                        }
                        case "shift":
                            config.setAlgorithm(Cipher.Algorithm.SHIFT);
                            break;
                    }
                    break;
                }
            }
        }

        return config.build();
    }

}
