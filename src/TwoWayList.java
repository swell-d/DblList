class TwoWayList implements SwCollections {
    Element lastElement;

    TwoWayList() {
        this.lastElement = null;
    }

    @Override
    public void add(String text) {
        Element newElement = new Element(this.lastElement, text, null);
        if (this.lastElement != null) this.lastElement.next = newElement;
        this.lastElement = newElement;
    }

    @Override
    public Iterators createSimpleIterator() {
        return new SimpleIterator(this);
    }
}
