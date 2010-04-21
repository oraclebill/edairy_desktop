package com.agritrace.edairy.common.datamodel.dairy;

import javax.persistence.*;
import com.agritrace.edairy.common.datamodel.common.*;

@Entity
public class Bin extends Container {
	private Long _binId;
	private Route _route;
	private CollectionCentre _collectionCentre;

	@GeneratedValue
	public Long getBinId() {
		return _binId;
	}
	public void setBinId(Long binId) {
		_binId = binId;
	}
	public Route getRoute() {
		return _route;
	}
	public void setRoute(Route route) {
		_route = route;
	}
	public CollectionCentre getCollectionCentre() {
		return _collectionCentre;
	}
	public void setCollectionCentre(CollectionCentre collectionCentre) {
		_collectionCentre = collectionCentre;
	}
}
