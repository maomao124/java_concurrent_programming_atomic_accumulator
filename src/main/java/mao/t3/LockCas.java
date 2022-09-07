package mao.t3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project name(项目名称)：java并发编程_原子累加器
 * Package(包名): mao.t3
 * Class(类名): LockCas
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 16:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class LockCas
{
    private final AtomicInteger state = new AtomicInteger(0);

    public void lock()
    {
        while (true)
        {
            if (state.compareAndSet(0, 1))
            {
                break;
            }
        }
        System.out.println("lock");
    }

    public void unlock()
    {
        System.out.println("unlock");
        state.set(0);
    }

}
