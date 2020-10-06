package org.itstep.List;


public class List {
    Element first;
    Element last;

    public List()
    {

    }
    public void addFist(int value){
        if (first == null)
        {
            first = new Element(value);
            last = first;
            /*//Емм, ссылки же по умолчанию на null ссылаются нет? зачем это?
            first.next = null;
            first.before = null;*/
        }
        else
        {
            Element tmp = new Element(value);
            first.before = tmp;
            tmp.next = first;
            first = tmp;
        }
    }
    public void addEnd(int value){
        if (last == null)
        {
            last = new Element(value);
            first = last;
        }
        else {
            Element tmp = new Element(value);
            tmp.before = last;
            last.next = tmp;
            last = tmp;
        }
    }
    public void addMiddle(int value, int index){
        if (index > -1) {
            if (first == null){
                if (index == 0){
                    //вставляем в начало пустого списка
                    addFist(value);
                }
            }
            else {
                //если вставляем в начало
                if (index == 0) {
                    addFist(value);
                    return;
                }
                //ищем подходящее место
                Element tmp;
                tmp = first;
                for (int i = 0; i < index; i++) {
                    if (tmp == null) {
                        return;
                    }//индекс >= длинны строки
                    tmp = tmp.next;
                }
                //вставляем если в конец
                if (tmp == null) {
                    addEnd(value);
                    return;
                }
                //вставляем если в середину
                Element newEl = new Element(value);
                newEl.before = tmp.before;
                newEl.next = tmp;
                tmp.before.next = newEl;
                tmp.before = newEl;

            }
        }
    }
    public void delFirst(){
        if (first != last) {
            first = first.next;//удалять же не надо да?
            first.before = null;
        }
        else{
            first = null;
            last = null;
        }
    }
    public void delLast(){
        if (first != last) {
        last = last.before;
        last.next = null;
        }
        else{
            first = null;
            last = null;
        }
    }
    public void delMiddle(int index){
        if (index > - 1){
            if (first != null){
                //удаляем из начала
                if (index == 0) {
                    delFirst();
                    return;
                }
                //ищем подходящее место
                Element tmp;
                tmp = first;
                for (int i = 0; i < index; i++) {
                    if (tmp == null) {
                        return;
                    }//индекс >= длинны строки
                    tmp = tmp.next;
                }
                //если вышли за пределы массива выходим
                if (tmp == null){
                    return;
                }
                if (tmp.next == null){
                    delLast();
                }
                else{
                    tmp.before.next = tmp.next;
                }
            }
        }
    }
    public void show(){
        Element current = first;//выделение памяти тут было бы избыточно, я правильно понял?
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();//Хм, пусть будет
    }
}

