package Main;

import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Bag extends Container{
    private final double capacity;
    private double currentWeight;

    public Bag(String name, double capacity){
        super(name);
        this.capacity = capacity;
        this.currentWeight = 0;
    }

    public void add(Item item){
        if(currentWeight + item.getWeight() <= capacity){
            if(contents.containsKey(item.getName())){
                contents.get(item.getName()).add(item);
            }
            else{
                contents.put(item.getName(), new ArrayList<>());
                contents.get(item.getName()).add(item);
            }
            currentWeight += item.getWeight();
        }
        else{
            System.out.println("Bag is full");
        }
    }

    public boolean hasRoom(Item item){
        return currentWeight + item.getWeight() <= capacity;
    }
}
