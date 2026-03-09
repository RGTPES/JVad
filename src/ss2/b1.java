package ss2;
public class b1 {
    // 1. Kiểm tra xem một User có phải là Admin hay không (trả về true/false)
    // Functional Interface phù hợp: Predicate<User>
    // Predicate dùng để kiểm tra một điều kiện và trả về giá trị boolean
    // (true/false).
    // Trong trường hợp này ta kiểm tra xem User có role là Admin hay không

    // 2. Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin
    // username
    // Functional Interface phù hợp: Function<User, String>
    // Giải thích:
    // Function<T, R> dùng để biến đổi một đối tượng đầu vào thành một giá trị khác.
    // Ở đây đầu vào là User, đầu ra là String.

    // 3. In thông tin chi tiết của User ra màn hình Console
    // Functional Interface phù hợp: Consumer<User>
    // Giải thích:
    // Consumer<T> dùng khi thực hiện một hành động với dữ liệu nhưng không trả về
    // kết quả.
    // Ở đây là in thông tin User ra màn hình.

    // 4. Khởi tạo một đối tượng User mới với các giá trị mặc định
    // Functional Interface phù hợp: Supplier<User>
    // Giải thích:
    // Supplier<T> dùng khi không có đầu vào nhưng trả về một đối tượng.
    // Trong trường hợp này là tạo ra một User mới.
    }


