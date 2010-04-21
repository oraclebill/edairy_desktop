package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

@Embeddable
public class AssetData {
	@GeneratedValue
	private Long _assetId;
	
	@Column(nullable=false)
	private Date _purchaseDate;
	private Date _damageDate;
	private Date _disposalDate;
	private String _disposalMethod;
	private String _witness;
}
