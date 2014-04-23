package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 *
 */
@PersistenceCapable
public class Molecule {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private long id;

	private long projectId;

	private String name, smiles;

	public Molecule(String name, String smiles, long projectId) {
		this.name = name;
		this.smiles = smiles;
		this.projectId = projectId;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	@Override
	public String toString() {
		return "Molecule [id=" + id + ", name=" + name + ", smiles=" + smiles + "]";
	}
}