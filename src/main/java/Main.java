import CpuLIb.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.*;

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

        //Диапозон
        System.out.println(executor.getMemDiap());


        //Рапспечатка всех команд
        Map<CommandType, Long> mapCommands =
                programm.stream().collect(Collectors.groupingBy(Command::getType, Collectors.counting()));

        mapCommands.entrySet().forEach(System.out::println);
        System.out.println();

        //Максимальный
        Map.Entry<CommandType, Long> MaxInstruction =
                mapCommands.entrySet().stream()
                        .max(Map.Entry.comparingByValue()).orElse(null);



        System.out.println(MaxInstruction);

        System.out.println();

        //В порядке убывание по колву использования
        List<CommandType> setCommands = programm.stream().collect(Collectors
                .groupingBy(Command::getType, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<CommandType, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(setCommands);;
    }
}
