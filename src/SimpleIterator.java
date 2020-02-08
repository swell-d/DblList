class SimpleIterator<T> implements Iterators<T> {
    private final TwoWayList<T> list;
    private Element<T> currentElement;

    SimpleIterator(TwoWayList<T> list) {
        this.list = list;
        this.currentElement = null;
    }

    @Override
    public T nextElement() {
        checkCurrentElement();
        return moveTo(this.currentElement.next);
    }

    @Override
    public T previousElement() {
        checkCurrentElement();
        return moveTo(this.currentElement.previous);
    }

    private void checkCurrentElement() {
        if (this.currentElement != null) return;
        Element<T> lastElement = this.list.lastElement;
        if (lastElement == null) throw new IllegalCallerException("Empty List");
        while (lastElement.previous != null) lastElement = lastElement.previous;
        this.currentElement = new Element<>(null, null, lastElement);
    }

    private T moveTo(Element<T> element) {
        if (element == null) throw new IllegalCallerException("End of DblList");
        this.currentElement = element;
        return this.currentElement.value;
    }
}
