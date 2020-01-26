class SimpleIterator implements Iterators {
    private final TwoWayList list;
    private Element currentElement;

    SimpleIterator(TwoWayList list) {
        this.list = list;
        this.currentElement = null;
    }

    private Element lookForStartPosition() {
        Element lastElement = this.list.lastElement;
        if (lastElement == null) throw new IllegalCallerException("Empty List");
        while (lastElement.previous != null) lastElement = lastElement.previous;
        return new Element(null, null, lastElement);
    }

    @Override
    public String nextElement() {
        if (this.currentElement == null) this.currentElement = lookForStartPosition();
        return moveTo(this.currentElement.next);
    }

    @Override
    public String previousElement() {
        if (this.currentElement == null) this.currentElement = lookForStartPosition();
        return moveTo(this.currentElement.previous);
    }

    private String moveTo(Element element) {
        if (element == null) throw new IllegalCallerException("End of DblList");
        this.currentElement = element;
        return this.currentElement.value;
    }
}
