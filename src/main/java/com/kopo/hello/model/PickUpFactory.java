package com.kopo.hello.model;
import com.kopo.hello.cafeVO.pickUp.PickUp;
import com.kopo.hello.cafeVO.pickUp.PickUpEatIn;
import com.kopo.hello.cafeVO.pickUp.PickUpTakeOut;

import java.util.HashMap;
import java.util.Map;

public class PickUpFactory {
    private static final Map<String, PickUp> pickUpMap = new HashMap<>();

    static {
        pickUpMap.put("Eat-in", new PickUpEatIn());
        pickUpMap.put("Take-out", new PickUpTakeOut());

        // 새로운 픽업 방식 확장을 위한 Factory Pattern
        // pickUpMap.put("Drive-thru", new PickUpDriveThru());

    }

    public static PickUp getPickUp(String type) {
        return pickUpMap.getOrDefault(type, new PickUpTakeOut()); // 기본값으로 포장 주문
    }
}
