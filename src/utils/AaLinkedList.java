package utils;
import java.util.Arrays;

import middlewareManager.middlewares.Middleware;
public class AaLinkedList {

    public class LinkedElement {
        public Middleware middleware;
        public LinkedElement next;

        public LinkedElement(Middleware middleware) {
            this.middleware = middleware;
        }

        public LinkedElement getNext() {
            return next;
        }

        public void setNext(LinkedElement linkedElement) {
            this.next = linkedElement;
        }

        public Middleware getMiddleware() {
            return middleware;
        }
    }

    public class Iterator {
        LinkedElement cursor;
        public Iterator(LinkedElement head) {
            this.cursor = head;
        }

        public Boolean hasNext() {
            if (this.cursor != null) return true;
            return false;
        }

        public LinkedElement getNext() {
            LinkedElement next = cursor;
            if (this.hasNext()) {
                this.cursor = this.cursor.getNext();
            } else {
                this.cursor = null;
            }

            return next;
        }
    }
    

    LinkedElement head;
    LinkedElement lastAddedLinkedElement;
    int size = 0;

    public void setHead(LinkedElement linkedElement) {
        this.head = linkedElement;
    }

    public LinkedElement getHead() {
        return head;
    }

    public LinkedElement getTail() {
        LinkedElement cursor = getHead();
        if (cursor == null) return null;
        while(cursor.getNext() != null) {
            cursor = cursor.getNext();
        }

        return cursor;
    }

    public LinkedElement[] getCoupleTail() {
        LinkedElement[] result = new LinkedElement[2];
        LinkedElement beforeTail;
        LinkedElement tail;
        beforeTail = this.getHead();

        if (beforeTail == null){
            //System.out.println("before tail is null");
            return result;
        }
        tail = beforeTail.getNext();
        if (tail == null) {
            //System.out.println("tail is null");
            //System.out.println(Arrays.toString(result));
            result[1] = beforeTail;
            return result;
        };

        while(tail.getNext() != null) {
            beforeTail = tail;
            tail = tail.getNext();
        }

        result[0] = beforeTail;
        result[1] = tail;

        return result;
    }

    public Iterator getIterator() {
        return new Iterator(head);
    }

    public void add(Middleware middleware) {
        add(new LinkedElement(middleware));
    }

    public void add(LinkedElement newElement) {
        if (newElement == null) {
            return;
        }
        //System.out.println(head);
        //System.out.println(newElement);
        LinkedElement tail = this.getTail();
        if (tail == null) {
            //System.out.println("here");
            this.head = newElement;
        } else {
            tail.setNext(newElement);
        }
        this.afterAdd(newElement);
        size++;
    }

    public void addAtStart(Middleware middleware) {
        addAtStart(new LinkedElement(middleware));
    }

    public void addAtStart(LinkedElement element) {
        if (this.getHead() != null) {
            element.setNext(this.getHead());
        }

        this.setHead(element);
        this.afterAdd(element);
        size++;
    }

    public void addAfter(Middleware middleware, LinkedElement element) {
        addAfter(new LinkedElement(middleware), element);
    }

    public void addAfter(LinkedElement element, LinkedElement beforeElement) {
        int beforeElementIndex = this.findIndex(beforeElement);
        if (beforeElementIndex == -1) return;
        element.setNext(beforeElement.getNext());
        beforeElement.setNext(element);
        this.afterAdd(element);
        size++;
    }

    public void addBefore(Middleware middleware ,LinkedElement element) {
        addBefore(new LinkedElement(middleware), element);
    }

    public void addBefore(LinkedElement element, LinkedElement afterElement) {

    }

    public int findIndex(Middleware middleware) {
        return findIndex(middleware.getLinkedElement());
    }

    public int findIndex(LinkedElement element) {
        int i = 0;
        Iterator iterator = this.getIterator();
        while(iterator.hasNext()) {
            if (iterator.getNext() == element) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public LinkedElement getByIndex(int index) {
        if (index < 0) return null;

        Iterator iterator = this.getIterator();
        LinkedElement result;
        while(iterator.hasNext()) {
            result = iterator.getNext();
            index--;
            if (index == -1) {
                //System.out.println("found by index");
                //System.out.println(result);
                //System.out.println("-------");
                return result;
            } ;
        }

        return null;
    }

    public void removeLast() {
        LinkedElement[] coupleTail = getCoupleTail();
        LinkedElement tail = coupleTail[1];
        LinkedElement beforeTail = coupleTail[0];


        if (tail != null) {
            if (beforeTail == null) {
                //System.out.println("beforeTail is null");
                this.head = null;
            } else {
                beforeTail.setNext(null);
            }

            size--;
        }

        
    }

    public void remove(LinkedElement element) {
        if (element == null) return;

        int elementIndex = this.findIndex(element);
        if (elementIndex == -1) return;

        if (elementIndex == 0) {
            this.head = element.getNext();
        } else {
            LinkedElement beforeElement = this.getByIndex(elementIndex - 1);
            LinkedElement nextElement = element.getNext();

            beforeElement.setNext(nextElement);
        }

        size--;
    } 

    public void afterAdd(LinkedElement addedElement) {
        this.lastAddedLinkedElement = addedElement;
    }

    public LinkedElement getLastAddedLinkedElement() {
        return lastAddedLinkedElement;
    }

    @Override
    public String toString() { 
        Iterator iterator = new Iterator(this.head);
        String output = "";
        output += "size: " + this.size + " \n";
        int i = 0;
        while(iterator.hasNext()) {
            output += (i++) + ": " + iterator.getNext().getMiddleware().toString() + "\n";
        }

        return output;

    }
}
