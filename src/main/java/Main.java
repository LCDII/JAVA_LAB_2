import CpuLIb.*;

public class Main {
    public static void main(String[] args) {
        Command[] prog = new Command[]{
                new Command(CommandType.INIT, new String[]{"10", "20"}),
                new Command(CommandType.INIT, new String[]{"11", "25"}),
                new Command(CommandType.LD, new String[]{"a", "10"}),
                new Command(CommandType.LD, new String[]{"b", "11"}),
                new Command(CommandType.ADD, new String[0]),
                new Command(CommandType.PRINT, new String[0])};
        ICpu cpu = FCpu.build();
        Executor executor = new Executor(cpu);
        executor.run(prog);
    }
}
