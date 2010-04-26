package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

@Embeddable
public class AssetData {
	private Long _assetId;
	
	private Date _purchaseDate;
	private Date _damageDate;
	private Date _disposalDate;
	private String _disposalMethod;
	private String _witness;

//	@GeneratedValue
	public Long getAssetId() {
		return _assetId;
	}
	public void setAssetId(Long assetId) {
		_assetId = assetId;
	}
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getPurchaseDate() {
		return _purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		_purchaseDate = purchaseDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getDamageDate() {
		return _damageDate;
	}
	public void setDamageDate(Date damageDate) {
		_damageDate = damageDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getDisposalDate() {
		return _disposalDate;
	}
	public void setDisposalDate(Date disposalDate) {
		_disposalDate = disposalDate;
	}
	public String getDisposalMethod() {
		return _disposalMethod;
	}
	public void setDisposalMethod(String disposalMethod) {
		_disposalMethod = disposalMethod;
	}
	public String getWitness() {
		return _witness;
	}
	public void setWitness(String witness) {
		_witness = witness;
	}
	
	
}
