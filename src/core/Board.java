package core;


public interface Board<T> {
	
	public boolean contains(Position p);
	public T get(Position p) throws PositionOutOfBoundsException;
	public T unsafeGet(Position p);
	public void set(Position p, T t);

}
