package Application.Builders.Interfaces;

public interface IBuilder<T> {
    IBuilder reset();
    T build();
}
