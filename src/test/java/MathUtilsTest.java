import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

    // Th1 1: Kiểm tra phép chia bình thường (Vùng dữ liệu hợp lệ)
    @Test
    public void testDivide_NormalCase() {
        int a = 10;
        int b = 2;
        double expected = 4.5; // cố tình để sai test gây ra lỗi ci/cd
        double actual = MathUtils.divide(a, b);
        assertEquals(expected, actual, 0.0001, "Phép chia 10 cho 2 phải bằng 5.0");
    }

    // Th1 2: Kiểm tra lỗi chia cho 0 (Ngoại lệ)
    @Test
    public void testDivide_ByZero_ShouldThrowException() {
        int a = 5;
        int b = 0;
        // Kiểm tra xem hệ thống có ném ra đúng lỗi IllegalArgumentException khi b = 0 không
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(a, b);
        }, "Hàm phải báo lỗi IllegalArgumentException khi mẫu số bằng 0");
    }
}
