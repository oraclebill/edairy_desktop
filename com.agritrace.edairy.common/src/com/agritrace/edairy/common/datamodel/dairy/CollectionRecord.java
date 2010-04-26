package com.agritrace.edairy.common.datamodel.dairy;

import java.math.BigDecimal;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Container;

@Entity
public class CollectionRecord {
	private Long _collectionRecordId; // database id
	private int _journalSequence; // line number
	private String _recordedMemberId; // membership number
	private Container _can;
	private BigDecimal _quantityCollected;

	private boolean _isNotRecorded;
	private boolean _isRejected;
	private boolean _isSuspended; // flagged
	private boolean _isOffRoute;

	@Id
	@GeneratedValue
	public Long getCollectionRecordId() {
		return _collectionRecordId;
	}

	public void setCollectionRecordId(Long collectionRecordId) {
		_collectionRecordId = collectionRecordId;
	}

	public int getJournalSequence() {
		return _journalSequence;
	}

	public void setJournalSequence(int journalSequence) {
		_journalSequence = journalSequence;
	}

	public String getRecordedMemberId() {
		return _recordedMemberId;
	}

	public void setRecordedMemberId(String recordedMemberId) {
		_recordedMemberId = recordedMemberId;
	}

	public Container getCan() {
		return _can;
	}

	public void setCan(Container can) {
		_can = can;
	}

	public BigDecimal getQuantityCollected() {
		return _quantityCollected;
	}

	public void setQuantityCollected(BigDecimal quantityCollected) {
		_quantityCollected = quantityCollected;
	}

	public boolean isNotRecorded() {
		return _isNotRecorded;
	}

	public void setNotRecorded(boolean isNotRecorded) {
		_isNotRecorded = isNotRecorded;
	}

	public boolean isSuspended() {
		return _isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		_isSuspended = isSuspended;
	}

	public boolean isOffRoute() {
		return _isOffRoute;
	}

	public void setOffRoute(boolean isOffRoute) {
		_isOffRoute = isOffRoute;
	}

	public boolean isRejected() {
		return _isRejected;
	}

	public void setRejected(boolean isRejected) {
		_isRejected = isRejected;
	}

	// TODO: derived farm..
	//

}
