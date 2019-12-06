package objects;

import java.io.Serializable;

public class AdministratorRole extends Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean canAddMember;

	private boolean canEditMember;

	private boolean canRemoveMember;

	private boolean canAddBook;

	private boolean canCheckout;

	public AdministratorRole() {
		setCanAddMember(true);
		setCanEditMember(true);
		setCanRemoveMember(true);
		setCanAddBook(true);
		setCanCheckout(false);
	}

	public boolean isCanAddMember() {
		return canAddMember;
	}

	public void setCanAddMember(boolean canAddMember) {
		this.canAddMember = canAddMember;
	}

	public boolean isCanEditMember() {
		return canEditMember;
	}

	public void setCanEditMember(boolean canEditMember) {
		this.canEditMember = canEditMember;
	}

	public boolean isCanRemoveMember() {
		return canRemoveMember;
	}

	public void setCanRemoveMember(boolean canRemoveMember) {
		this.canRemoveMember = canRemoveMember;
	}

	public boolean isCanAddBook() {
		return canAddBook;
	}

	public void setCanAddBook(boolean canAddBook) {
		this.canAddBook = canAddBook;
	}

	public boolean isCanCheckout() {
		return canCheckout;
	}

	public void setCanCheckout(boolean canCheckout) {
		this.canCheckout = canCheckout;
	}

}
