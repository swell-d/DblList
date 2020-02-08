class Element<T> {
    Element<T> previous;
    T value;
    Element<T> next;

    Element(Element<T> previous, T value, Element<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }
}
