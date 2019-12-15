package soft.bigeran.dervis.Interfaces;

public interface OnEventListener<T> {

    public void onSuccess(T object);
    public void onFailure(Exception e);
    public void onTaskContinue();

}