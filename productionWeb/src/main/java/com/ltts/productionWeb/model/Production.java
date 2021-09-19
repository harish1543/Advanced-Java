package com.ltts.productionWeb.model;

public class Production {
	
	private int productionId;
	private String productionName;
	private String address;
	private int startDate;
	private String ownerName;
	public Production(int productionId, String productionName, String address, int startDate, String ownerName) {
		super();
		this.productionId = productionId;
		this.productionName = productionName;
		this.address = address;
		this.startDate = startDate;
		this.ownerName = ownerName;
		System.out.println("Production Custructor Success");
	}
	/*public Production() {
		super();
	}*/
	public int getProductionId() {
		return productionId;
	}
	@Override
	public String toString() {
		return "Production [productionId=" + productionId + ", productionName=" + productionName + ", address="
				+ address + ", startDate=" + startDate + ", ownerName=" + ownerName + "]";
	}
	public void setProductioId(int productioId) {
		this.productionId = productioId;
	}
	public String getProductionName() {
		return productionName;
	}
	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}