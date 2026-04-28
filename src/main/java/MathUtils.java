import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// cho thư viện logback vào pom nên mới import và dùng dc logger dấy

public class MathUtils {
    // Tạo một máy ghi log riêng cho class MathUtils
    // thường được đặt là static final vì mỗi class chỉ cần một máy ghi log dùng chung
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public static double divide(int a, int b) {
        // Ghi lại thông tin luồng hoạt động bình thường (Dùng thay cho System.out.println)
        logger.info("Bắt đầu thực hiện phép chia {} cho {}", a, b);

        if (b == 0) {
            // Ghi lại lỗi nghiêm trọng nếu ai đó chia cho 0
            logger.error("Lỗi toán học: Không thể chia cho số 0!");
            throw new IllegalArgumentException("Số chia b không được bằng 0");
        }

        double result = (double) a / b;
        // Ghi lại thông tin gỡ lỗi (chỉ những lập trình viên mới cần xem mức độ này)
        logger.debug("Kết quả phép chia là: {}", result);
        return result;
    }

    public static void main(String[] args) {
        // chạy thử
        MathUtils.divide(10, 2);

        try {
            MathUtils.divide(5, 0);
        } catch (Exception e) {
            // Log luôn cả cái lỗi (Exception) ra để xem chi tiết
            logger.error("Hệ thống gặp sự cố: ", e);
        }
    }
}
// các mức độ là
// logger.trace(): Chi tiết vụn vặt nhất (ít dùng).
// logger.debug(): Dùng khi đang viết code và muốn in ra các biến số để kiểm tra xem thuật toán chạy đúng không
// logger.info(): Thông báo hoạt động bình thường, thay thế cho sout
// logger.warn(): Cảnh báo, ctrinh vẫn chạy nma caanf lưu ý
// logger.error(): Lỗi nghiêm trọng, chương trình bị văng, sai logic