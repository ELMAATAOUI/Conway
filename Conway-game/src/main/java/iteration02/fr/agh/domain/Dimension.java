package iteration02.fr.agh.domain;
/**
 * @author elm
 *
 */
public class Dimension {

	private final int x;
	private final int y;
	/**
	 * @param x
	 * @param y
	 */
	public Dimension(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dimension [x=" + x + ", y=" + y + "]";
	}
	
	
}
