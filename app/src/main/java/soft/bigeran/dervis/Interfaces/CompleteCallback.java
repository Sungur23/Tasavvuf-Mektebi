package soft.bigeran.dervis.Interfaces;

public interface CompleteCallback<T> {
    void onComplete(T object);
    void onFailed(Exception e);
}
