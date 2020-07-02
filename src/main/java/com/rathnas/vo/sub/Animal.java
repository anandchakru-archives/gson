package com.rathnas.vo.sub;

import com.rathnas.vo.Thing;
import com.rathnas.vo.iThing;

public class Animal extends Thing implements iThing {
	private Integer legs;
	private Integer wings;

	public Integer getLegs() {
		return legs;
	}
	public void setLegs(Integer legs) {
		this.legs = legs;
	}
	public Integer getWings() {
		return wings;
	}
	public void setWings(Integer wings) {
		this.wings = wings;
	}
	@Override
	public String toString() {
		return "Animal [legs=" + legs + ", wings=" + wings + ", noise=" + super.getNoise() + "]";
	}
}
