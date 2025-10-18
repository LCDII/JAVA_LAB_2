package CpuLIb;

public interface ICpu {
    void execute(Command cmd) throws CpuException;
    public  int[] getAllMem();
}
