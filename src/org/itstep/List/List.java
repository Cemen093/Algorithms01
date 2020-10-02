package org.itstep.List;
public class List {
    Element first;

    public List()
    {

    }
    public void addFict(int value){
        if (first == null)
        {
            first = new Element(value);
            first.next = null;
        }
        else
        {
            Element tmp = new Element(value);
            tmp.next = first;
            first = tmp;
        }
    }
    public void show(){
        Element current = new Element();
        current = first;
        while (current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}

