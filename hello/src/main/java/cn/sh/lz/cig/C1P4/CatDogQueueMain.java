package cn.sh.lz.cig.C1P4;

/***
 * @author Link
 * @date 2020/07/20
 * @time 10:34
 */
public class CatDogQueueMain {
    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();
        queue.add(new Cat());
        queue.add(new Dog());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());

        queue.pollCat();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());

        queue.pollAll();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());
    }
}
