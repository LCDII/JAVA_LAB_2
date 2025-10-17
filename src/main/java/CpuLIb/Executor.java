package CpuLIb;

public class Executor {
    private ICpu cpu;

    public Executor(ICpu cpu) {
        this.cpu = cpu;
    }

    public void run(Prog prog) {
        for(Command command : prog) {
                try {
                    cpu.execute(command);
                } catch (CpuException e) {
                    System.out.println(e.getMessage());
                }
        }

    }
}
