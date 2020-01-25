class Element {
    Element previous;
    String value;
    Element next;

    Element(Element previous, String value, Element next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

}
