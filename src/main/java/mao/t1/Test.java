package mao.t1;

import java.util.concurrent.atomic.LongAdder;

/**
 * Project name(项目名称)：java并发编程_原子累加器
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 16:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 100; i++)
        {
            longAdder.increment();
        }
        System.out.println(longAdder.longValue());
    }
}
