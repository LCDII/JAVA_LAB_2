import CpuLIb.*;

public class Main {
    public static void main(String[] args) {

        Prog programm = new Prog(6);
        programm.add(new Command(CommandType.INIT, new String[]{"10", "20"}));
        programm.add(new Command(CommandType.INIT, new String[]{"11", "25"}));
        programm.add(new Command(CommandType.LD, new String[]{"a", "10"}));
        programm.add(new Command(CommandType.LD, new String[]{"b", "11"}));
        programm.add(new Command(CommandType.ADD, new String[0]));
        programm.add(new Command(CommandType.PRINT, new String[0]));


        ICpu cpu = FCpu.build();
        Executor executor = new Executor(cpu);
        executor.run(programm);
    }
}
