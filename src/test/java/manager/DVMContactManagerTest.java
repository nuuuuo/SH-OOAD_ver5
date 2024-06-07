package manager;

import data.DVM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVMContactManagerTest {
    private final DVMContactManager manager = new DVMContactManager();

    @Test
    void searchDrinkTest() {
        // 가정: 서버가 "02", 10에 대한 재고를 반환하는 경우
        DVM result = manager.searchDrink("02", 10);
        assertNotNull(result, "가장 가까운 자판기의 위치를 반환해야 합니다.");
        System.out.println("가장 가까운 자판기 위치: (" + ((DVM) result).getX() + ", " + result.getY() + ")");
    }

    @Test
    void reqAdvancePaymentTest() {
        // 가정: "02", 10, "123456"에 대한 선결제가 가능한 경우
        boolean result = manager.reqAdvancePayment("02", 10, "123456");
        assertTrue(result, "선결제가 가능한 경우 true를 반환해야 합니다.");

        // 가정: "02", 10, "000000"에 대한 선결제가 불가능한 경우
        result = manager.reqAdvancePayment("02", 10, "000000");
        assertFalse(result, "선결제가 불가능한 경우 false를 반환해야 합니다.");
    }
}