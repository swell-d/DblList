class TwoWayList<T> implements SwCollections<T> {
    Element<T> lastElement;

    TwoWayList() {
        this.lastElement = null;
    }

    @Override
    public void add(T text) {
        Element<T> newElement = new Element<>(this.lastElement, text, null);
        if (this.lastElement != null) this.lastElement.next = newElement;
        this.lastElement = newElement;
    }

    @Override
    public Iterators createSimpleIterator() {
        return new SimpleIterator<>(this);
    }
}
