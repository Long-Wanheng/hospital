package com.agoi.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "drug_status")
public class DrugStatus  implements Serializable {

	@Column(name = "drug_id")
	private Integer drugId;

	@Column(name = "status_name")
	private String statusName;

}
