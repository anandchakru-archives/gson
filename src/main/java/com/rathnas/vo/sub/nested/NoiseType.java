package com.rathnas.vo.sub.nested;

public abstract class NoiseType {
	private String noise;

	public NoiseType(String noise) {
		super();
		this.noise = noise;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}
	@Override
	public String toString() {
		return "NestedAbstractClass [noise=" + noise + "]";
	}
}
