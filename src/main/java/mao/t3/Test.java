package mao.t3;

/**
 * Project name(项目名称)：java并发编程_原子累加器
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 16:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        LockCas lockCas = new LockCas();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                lockCas.lock();
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    System.out.println("t1线程释放锁");
                    lockCas.unlock();
                }
            }
        }, "t1").start();

        Thread.sleep(100);
        System.out.println("主线程尝试获取锁");
        lockCas.lock();
        System.out.println("主线程获取锁成功");
    }
}
