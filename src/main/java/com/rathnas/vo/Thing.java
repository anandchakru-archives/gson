package com.rathnas.vo;

import com.rathnas.vo.sub.nested.NoiseType;

public abstract class Thing {
	private String name;
	private NoiseType noise;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NoiseType getNoise() {
		return noise;
	}
	public void setNoise(NoiseType noise) {
		this.noise = noise;
	}
}
