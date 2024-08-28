package com.kopo.cafe.model;
import java.util.HashMap;
import java.util.Map;

import com.kopo.cafe.global.util.PickUp;
import com.kopo.cafe.global.util.PickUpEatIn;
import com.kopo.cafe.global.util.PickUpTakeOut;

public class PickUpFactory {
    private static final Map<String, PickUp> pickUpMap = new HashMap<>();

    static {
        pickUpMap.put("Eat-in", new PickUpEatIn());
        pickUpMap.put("Take-out", new PickUpTakeOut());

        // 새로운 픽업 방식 확장을 위한 Factory Pattern -> Drive Thru 방식을 추가하면 여기에 추가
        // pickUpMap.put("Drive-thru", new PickUpDriveThru());

    }

    public static PickUp getPickUp(String type) {
        return pickUpMap.getOrDefault(type, new PickUpTakeOut()); // 기본값으로 포장 주문
    }
}
