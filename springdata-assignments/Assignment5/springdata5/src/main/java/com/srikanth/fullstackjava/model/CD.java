package com.srikanth.fullstackjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cd")
@NamedQueries({
	@NamedQuery(name = "CD.findByCdPrice",
				query = "SELECT c from CD c where c.cdPrice > :price "),
	@NamedQuery(name = "CD.countByCdPrice",
				query = "SELECT count(c) from CD c where c.cdPrice > :price "),
})
public class CD {

	@Id
	@Column(name = "cd_id")
	private Long cdId;

	@Column(name = "cd_title")
	private String cdTitle;

	@Column(name = "cd_price")
	private Double cdPrice;

	@Column(name = "cd_publisher")
	private String cdPublisher;

	public CD() {
		super();
	}

	public CD(Long cdId, String cdTitle, Double cdPrice, String cdPublisher) {
		super();
		this.cdId = cdId;
		this.cdTitle = cdTitle;
		this.cdPrice = cdPrice;
		this.cdPublisher = cdPublisher;
	}

	public Long getCdId() {
		return cdId;
	}

	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	public Double getCdPrice() {
		return cdPrice;
	}

	public void setCdPrice(Double cdPrice) {
		this.cdPrice = cdPrice;
	}

	public String getCdPublisher() {
		return cdPublisher;
	}

	public void setCdPublisher(String cdPublisher) {
		this.cdPublisher = cdPublisher;
	}

}
