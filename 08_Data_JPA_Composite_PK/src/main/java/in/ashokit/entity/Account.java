package in.ashokit.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
@Entity
public class Account {
	
	private String holderName;
	private String branchName;
	
	@EmbeddedId
	private AccountPK accountPK;

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public AccountPK getAccountPK() {
		return accountPK;
	}

	public void setAccountPK(AccountPK accountPK) {
		this.accountPK = accountPK;
	}

	@Override
	public String toString() {
		return "Account [holderName=" + holderName + ", branchName=" + branchName + ", accountPK=" + accountPK + "]";
	}

	
	
}
