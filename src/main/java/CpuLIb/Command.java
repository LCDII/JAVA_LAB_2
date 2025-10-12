package CpuLIb;

import java.util.Arrays;

public class Command {

    private String[] args;
    private CommandType type;

    public Command(CommandType type, String... args) {
        this.type = type;
        this.args = args;
    }

    public CommandType getType() {
        return type;
    }

    public String[] getArgs() {
        return args;
    }

    public String toString() {
        String s = Arrays.toString(args);
        return "Command{args=" + s + ", type=" + String.valueOf(type) + "}";
    }
}
