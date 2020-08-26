package p1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private String extTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private int marketValue;
	private char priorityFlag;
	private int fee;
	
	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getExtTransactionId() {
		return extTransactionId;
	}

	public void setExtTransactionId(String extTransactionId) {
		this.extTransactionId = extTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public char getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(char priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public Transaction(String[] s) {
		try {
			this.extTransactionId = s[0];
			this.clientId = s[1];
			this.securityId = s[2];
			this.transactionType = s[3];
			this.transactionDate = new SimpleDateFormat("MM/DD/YYYY").parse(s[4]);
			this.marketValue = Integer.parseInt(s[5]);
			this.priorityFlag =s[6].charAt(0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Transaction [extTransactionId=" + extTransactionId + ", clientId=" + clientId + ", securityId="
				+ securityId + ", transactionType=" + transactionType + ", transactionDate=" + transactionDate
				+ ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag + "]";
	}

}
