class SimpleIterator implements Iterators {
    private final TwoWayList list;
    private Element currentElement;

    SimpleIterator(TwoWayList list) {
        this.list = list;
        this.currentElement = null;
    }

    @Override
    public String nextElement() {
        checkCurrentElement();
        return moveTo(this.currentElement.next);
    }

    @Override
    public String previousElement() {
        checkCurrentElement();
        return moveTo(this.currentElement.previous);
    }

    private void checkCurrentElement() {
        if (this.currentElement != null) return;
        Element lastElement = this.list.lastElement;
        if (lastElement == null) throw new IllegalCallerException("Empty List");
        while (lastElement.previous != null) lastElement = lastElement.previous;
        this.currentElement = new Element(null, null, lastElement);
    }

    private String moveTo(Element element) {
        if (element == null) throw new IllegalCallerException("End of DblList");
        this.currentElement = element;
        return this.currentElement.value;
    }
}
