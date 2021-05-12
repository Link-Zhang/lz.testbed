package cn.sh.lz.cig.C1P4;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author Link
 * @date 2020/07/20
 * @time 10:05
 */
public class CatDogQueue {
    private Queue<PetEnterQueue> catQ;
    private Queue<PetEnterQueue> dogQ;
    private long count = 0;

    public CatDogQueue() {
//      频繁插入删除，使用LinkedList
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void offer(Pet pet) {
        if ("cat".equals(pet.getPetType())) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else if ("dog".equals(pet.getPetType())) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("Not cat or dog!");
        }
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isEmpty() {
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public Cat pollCat() {
        if (!this.isCatEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        }
        throw new RuntimeException("Cat Queue is empty!");
    }

    public Dog pollDog() {
        if (!this.isDogEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        }
        throw new RuntimeException("Dog Queue is empty!");
    }

    public Pet pollAll() {
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
            if (this.catQ.peek().getCount() < this.dogQ.peek().getCount()) {
                return this.catQ.poll().getPet();
            }
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        }
        throw new RuntimeException("Queue is empty!");
    }
}
