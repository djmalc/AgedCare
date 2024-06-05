package modules.agedCare.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Resident
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Resident extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "agedCare";

	/** @hidden */
	public static final String DOCUMENT_NAME = "Resident";

	/** @hidden */
	public static final String residentIDPropertyName = "residentID";

	/**
	 * ResidentID
	 **/
	private String residentID;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Resident.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Resident.DOCUMENT_NAME;
	}

	public static Resident newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage("Resident", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Resident) && 
					this.getBizId().equals(((Resident) o).getBizId()));
	}

	/**
	 * {@link #residentID} accessor.
	 * @return	The value.
	 **/
	public String getResidentID() {
		return residentID;
	}

	/**
	 * {@link #residentID} mutator.
	 * @param residentID	The new value.
	 **/
	@XmlElement
	public void setResidentID(String residentID) {
		preset(residentIDPropertyName, residentID);
		this.residentID = residentID;
	}
}
