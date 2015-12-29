package core;


public interface Board<T> {
	
	boolean contains(Position p);
	T get(Position p) throws PositionOutOfBoundsException;
	T unsafeGet(Position p);
	void set(Position p, T t);

}
