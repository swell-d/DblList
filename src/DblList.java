class DblList {
    private Element lastElement = null;
    private Element currentElement = null;

    void add(String text) {
        Element newElement = new Element(lastElement, text, null);
        if (lastElement != null) lastElement.next = newElement;
        lastElement = newElement;
        if (currentElement == null) currentElement = new Element(null, null, newElement);
    }

    String nextElement() {
        return moveTo(currentElement.next);
    }

    String previousElement() {
        return moveTo(currentElement.previous);
    }

    private String moveTo(Element element) {
        if (element == null) throw new IllegalCallerException("End of DblList");
        currentElement = element;
        return currentElement.value;
    }
}
