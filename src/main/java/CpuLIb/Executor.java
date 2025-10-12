package CpuLIb;

public class Executor {
    private ICpu cpu;

    public Executor(ICpu cpu) {
        this.cpu = cpu;
    }

    public void run(Command[] prog) {
        for(Command command : prog) {
            try {
                cpu.execute(command);
            } catch (CpuException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
