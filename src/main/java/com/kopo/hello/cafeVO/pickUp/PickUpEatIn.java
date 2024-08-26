package com.kopo.hello.cafeVO.pickUp;

import com.kopo.hello.cafeVO.pickUp.PickUp;

public class PickUpEatIn implements PickUp {
	@Override
	public String getPickUpType() {
		return "EatIn";
	}
}
