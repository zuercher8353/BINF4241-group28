public interface Observable {
    void registerObserver(Observer aObserver);
    void unregisterObserver(Observer aObserver);
    void notifyObservers(boolean isWhite, int points);
}
