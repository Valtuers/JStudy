package com.Concurrent.Container;

/**
 * 容器
 */
public class ContainerDemo {
    /*
        同步容器
        1、Vector，HashTable
        同步容器类的缺点:
            在单独使用里面的方法的时候，可以保证线程安全，但是，复合操作需要额外加锁来保证线程安全
            使用Iterator迭代容器或使用使用forEach遍历容器，在迭代过程中修改容器会抛出ConcurrentModificationException异常。
            想要避免出现ConcurrentModificationException，就必须在迭代过程持有容器的锁。
            但是若容器较大，则迭代的时间也会较长。那么需要访问该容器的其他线程将会长时间等待。从而会极大降低性能。
            若不希望在迭代期间对容器加锁，可以使用"克隆"容器的方式。
            使用线程封闭，由于其他线程不会对容器进行修改，可以避免ConcurrentModificationException。
            但是在创建副本的时候，存在较大性能开销。
            toString，hashCode，equalse，containsAll，removeAll，retainAll等方法都会隐式的Iterate，也即可能抛出ConcurrentModificationException。
        并发容器
        1、Concurrent和BlockingQueue：基于queue实现FIFO队列。队列为空，取操作会被阻塞
        2、ConcurrentLinkedQueue：队列为空，取得时候直接返回空
     */

}
