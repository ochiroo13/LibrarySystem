package objects;

import java.io.Serializable;
import java.util.Date;

public class Librarian extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	public Librarian() {
		super(false, true);
	}

}
