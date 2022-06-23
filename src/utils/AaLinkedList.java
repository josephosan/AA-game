package utils;
import middlewareManager.middlewares.Middleware;

public class AaLinkedList {
    public class LinkedElement {
        Middleware middleware;
        LinkedElement next;
        LinkedElement previous;

        public LinkedElement(Middleware _middleware) {
            middleware = _middleware;
        }

        public void setNext(LinkedElement nextMiddleware) {
            next = nextMiddleware;
        }

        public void setPrevious(LinkedElement previousMiddleware) {
            previous = previousMiddleware;
        }

        public LinkedElement getNext() {
            return next;
        }

        public LinkedElement getPrevious() {
            return previous;
        }

        public Middleware getMiddleware() {
            return middleware;
        }
    }

    public class Iterator {
        LinkedElement cursor;
        public Iterator(LinkedElement element) {
            cursor = element;
        }

        public Boolean hasNext() {
            if (cursor != null) {
                return true;
            }

            return false;
        }

        public LinkedElement next() {
            LinkedElement nextElement =  cursor;
            cursor = cursor.getNext();
            return nextElement;
        }
    }

    Iterator iterator;
    LinkedElement first;
    LinkedElement last;
    LinkedElement lastAddedLinkedElement;
    int size = 0;

    public AaLinkedList() {

    }

    public void add(Middleware middleware) {
        LinkedElement element = new LinkedElement(middleware);
        if (size == 0) {
            first = element;
            last = first;
        } else {
            element.setPrevious(last);
            last.setNext(element);
            last = element;
        }

        lastAddedLinkedElement = element;
        size++;
    }

    public void addAfter(Middleware middleware, LinkedElement element) {
        // if element is null we consider that the element should be add in the start of
        // of list
        if (element == null) {
            addAtStart(middleware);
            return;
        }
        LinkedElement newElement = new LinkedElement(middleware);
        newElement.setPrevious(element);
        LinkedElement lastElement = element.getNext();
        element.setNext(newElement);
        if (lastElement != null) {
            newElement.setNext(lastElement);
            lastElement.setPrevious(newElement);
        } else {
            last = newElement;
        }
        
        lastAddedLinkedElement = newElement;
        size++;
    }

    public void addBefore(Middleware middleware, LinkedElement element) {
        // if element is null we consider that the element should be add in the start of
        // of list
        if (element == null) {
            addAtStart(middleware);
            return;
        }
        LinkedElement newElement = new LinkedElement(middleware);
        newElement.setNext(element);    
        if(element.getPrevious() != null) {
            newElement.setPrevious(element.getPrevious());
            element.getPrevious().setNext(newElement);
        } else {
            // the newElement is first
            first = newElement;
        }
        element.setPrevious(newElement);
        
        lastAddedLinkedElement = newElement;
        size++;
    }

    public void addAtStart(Middleware middleware) {
        if (size == 0) {
            add(middleware);
        } else {
            addBefore(middleware, first);
        }
            
    }

    public void remove(LinkedElement element) {
        System.out.println(last);
        System.out.println(element);
        if (last == element) {
            last = element.getPrevious();
            if (last != null) {
                last.setNext(null);
            } else {
                first = null;
            }
        } else if (first == element) {
            first = element.getNext();
            if (first != null) {
                first.setPrevious(null);
            } else {
                last = null;
            }
        } else {
            LinkedElement previousElement = element.getPrevious();
            previousElement.setNext((element.getNext()));
            element.getNext().setPrevious(previousElement);
        }

        if (element == lastAddedLinkedElement) {
            lastAddedLinkedElement = last;
        }

        size--;
    }

    public LinkedElement getLastAddedLinkedElement() {
        return lastAddedLinkedElement;
    }

    public Iterator getIterator() {
        return new Iterator(first);
    }

    @Override
    public String toString() {
        Iterator iterator = getIterator();
        String output = "AaLinkedList with size " + size + " \n" + " first: " +( first == null ? "null" : first.getMiddleware().toString()) + " \n last: " + (last == null ? "null" : last.getMiddleware().toString()) + " \n";
        int i = 0;
        while(iterator.hasNext()) {
            output += (++i) + ": " + iterator.next().getMiddleware().toString() + " \n";
        }

        return output;
    }
}
