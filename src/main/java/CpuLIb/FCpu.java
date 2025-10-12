package CpuLIb;

public class FCpu {
    static Cpu cpu;

    public static ICpu build() {
        if (cpu == null) {
            cpu = new Cpu();
            cpu.getHandler().add(new ALUHandler()).add(new CMDHandler()).add(new MemHandler());
        }

        return cpu;
    }
}
