package test;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tuzhenyu on 17-10-12.
 * @author tuzhenyu
 */
public class Test {
   public static void main(String[] args) throws Exception{
      ReentrantLock reentrantLock = new ReentrantLock();
      reentrantLock.newCondition();
   }
}
