package objects;

import java.io.Serializable;
import java.util.Date;

public class Administrator extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Administrator() {
		super(false, true);
	}

}
