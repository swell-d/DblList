class DblList {
    private Element lastElement = new Element(null, null, null);
    private Element currentElement = new Element(null,null,null);

    void add(String text) {
        Element newElement = new Element(lastElement, text, null);
        lastElement.next = newElement;
        lastElement = newElement;
        if (currentElement.next == null) currentElement.next = newElement;
    }

    String nextElement(){
        return moveTo(currentElement.next);
    }

    String previousElement() {
        return moveTo(currentElement.previous);
    }

    private String moveTo(Element next) {
        if (next == null) {
            System.out.println("no more elements");
            return null;
        }
        currentElement = next;
        return currentElement.value;
    }
}
