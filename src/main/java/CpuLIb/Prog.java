package CpuLIb;

import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.stream.Stream;

public class Prog implements Iterable<Command>{

    Command []a;
    int cnt =0;



    public Prog(int n)
    {
        a = new Command[n];
    }

    public void add(Command command)
    {
        if(cnt >= a.length)throw  new RuntimeException("Невозможно добавить элемент");

        a[cnt] = command;
        cnt ++;
    }

    public int getCnt()
    {return cnt;}

    public Command getElem(int ind)
    {
        return a[ind];
    }

    public Stream<Command> stream()
    {
        return Arrays.stream(a);
    }

    @Override
    public Iterator<Command> iterator() {
        return new Iterator<Command>() {

            int current = 0 ;
            @Override
            public boolean hasNext() {
                return current < getCnt();
            }

            @Override
            public Command next() {
                if(!hasNext()) throw new RuntimeException("Элементы кончились");
                current++;
                return getElem(current-1);
            }

        };
    }
}
