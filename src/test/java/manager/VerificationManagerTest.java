package manager;

import static org.junit.jupiter.api.Assertions.*;

import data.VerificationCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationManagerTest {
    private VerificationManager manager;

    @BeforeEach
    void setUp() {
        manager = new VerificationManager();
    }

    @Test
    void saveCodeTest() {
        VerificationCode code = new VerificationCode("123456", "item01", 10);
        assertTrue(manager.saveCode(code), "새로운 코드가 성공적으로 저장되어야 합니다.");

        // 중복된 코드 저장 시도
        assertFalse(manager.saveCode(code), "중복된 코드는 저장되지 않아야 합니다.");
    }

    @Test
    void verifyCodeTest() {
        VerificationCode code = new VerificationCode("123456", "item01", 10);
        manager.saveCode(code);

        VerificationCode result = manager.verifyCode("123456");
        assertEquals("123456", result.getCode(), "저장된 코드가 올바르게 반환되어야 합니다.");
        assertEquals("item01", result.getDrinkType(), "저장된 음료 종류가 올바르게 반환되어야 합니다.");
        assertEquals(10, result.getDrinkNum(), "저장된 음료 수량이 올바르게 반환되어야 합니다.");

        VerificationCode invalidResult = manager.verifyCode("654321");
        assertTrue(invalidResult.getCode().isEmpty(), "저장되지 않은 코드는 빈 코드로 반환되어야 합니다.");
    }
}