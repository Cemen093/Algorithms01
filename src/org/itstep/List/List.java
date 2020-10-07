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
    public void addOnList(int value, int index){
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
    public void addOnList(int value){
        if (first == null || value < first.data){
            addFist(value);
        }
        else {
            Element current = first;
            while (current.next != null && value > current.next.data){
                current = current.next;
            }
            Element tmp = new Element(value);//10 мин думал почему он массив 0 заполняет
            tmp.next = current.next;
            current.next = tmp;
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
    public void delOnListIndex(int index){
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
    public void delOnListKey(int key){
        if (first != null){
            if (first.data == key){
                first = first.next;
            }
            else {
                Element current = first;
                while (current.next != null && current.next.data < key) {
                    current = current.next;
                }
                if (current.next != null && current.next.data == key) {
                    current.next = current.next.next;
                }
            }
        }
    }
    public void delOnListAllKey(int key){
        if (first != null){
            if (first.data == key){
                first = first.next;
            }
            else {
                Element current = first;
                while (current.next != null && current.next.data < key) {
                    current = current.next;
                }
                if (current.next != null && current.next.data == key) {
                    Element tmp = current;
                    while (tmp.next != null && tmp.next.data == key){
                        tmp = tmp.next;
                    }
                    current.next = tmp.next;
                }
            }
        }
    }
    public void show(){
        if (first != null){
            System.out.println("Лист: ");
            Element current = first;
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
        else{
            System.out.println("Лист пуст");
        }
    }
}

