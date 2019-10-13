public class K5GetTheLoop {
    public int loopSize(Node node) {
        Node tor = node.getNext();
        Node hare = tor.getNext();
        while (tor != hare) {
            tor = tor.getNext();
            hare = hare.getNext().getNext();
        }

        int period = 1;
        hare = tor.getNext();
        while (tor != hare) {
            hare = hare.getNext();
            period++;
        }

        return period;
    }
}