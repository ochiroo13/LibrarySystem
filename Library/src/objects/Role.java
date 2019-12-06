package objects;

abstract public class Role {

	private boolean canAddMember;

	private boolean canEditMember;

	private boolean canRemoveMember;

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

}
