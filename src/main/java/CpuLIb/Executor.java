package CpuLIb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
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

    public List<Integer> getMemDiap()
    {
        List<Integer> l = IntStream.range(0, cpu.getAllMem().length)
                .filter(x->cpu.getAllMem()[x] != 0)
                .boxed()//Преобразование в Stream<Integer>
                .collect(Collectors.toList());


        return l;
    }
}
