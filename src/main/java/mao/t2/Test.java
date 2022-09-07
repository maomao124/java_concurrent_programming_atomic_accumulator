package mao.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Project name(项目名称)：java并发编程_原子累加器
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 16:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    private static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action)
    {
        T adder = adderSupplier.get();
        long start = System.nanoTime();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++)
        {
            threads.add(new Thread(() ->
            {
                for (int j = 0; j < 1000000; j++)
                {
                    action.accept(adder);
                }
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(t ->
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(adder + " 花费的时间:" + (end - start) / 1000_000 + "ms");
    }

    public static void main(String[] args)
    {
        int total = 10;
        System.out.println("AtomicLong");
        for (int i = 0; i < total; i++)
        {
            demo(AtomicLong::new, AtomicLong::getAndIncrement);
        }
        System.out.println("---------------");
        System.out.println("LongAdder");
        for (int i = 0; i < total; i++)
        {
            demo(LongAdder::new, LongAdder::increment);
        }

    }

}
