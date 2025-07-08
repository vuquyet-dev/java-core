package Java8Features;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64EncodeDecode {
    public static void main(String[] args) {
        // =====================================
        // 1️⃣ Basic Base64 - encode/decode dữ liệu nhị phân thường (vd: mật khẩu, file config)
        // =====================================
        String password = "mySuperSecretPassword123!";
        Base64.Encoder basicEncoder = Base64.getEncoder();
        String encodedPassword = basicEncoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        System.out.println("Basic Encoded Password: " + encodedPassword);

        Base64.Decoder basicDecoder = Base64.getDecoder();
        String decodedPassword = new String(basicDecoder.decode(encodedPassword), StandardCharsets.UTF_8);
        System.out.println("Basic Decoded Password: " + decodedPassword);

        // =====================================
        // 2️⃣ URL Base64 - encode/decode token URL-safe, tránh ký tự không hợp lệ trong URL
        // =====================================
        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String encodedUrlToken = urlEncoder.encodeToString(jwtToken.getBytes(StandardCharsets.UTF_8));
        System.out.println("URL Encoded Token: " + encodedUrlToken);

        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        String decodedUrlToken = new String(urlDecoder.decode(encodedUrlToken), StandardCharsets.UTF_8);
        System.out.println("URL Decoded Token: " + decodedUrlToken);

        // =====================================
        // 3️⃣ MIME Base64 - encode nội dung email (vd: email body hoặc file đính kèm) theo chuẩn MIME
        // MIME encoder sẽ tự thêm line-break sau 76 ký tự để đúng chuẩn RFC 2045 (dành cho email, SMTP)
        // =====================================
        String emailBody = "Subject: Test Email\n"
                + "From: sender@example.com\n"
                + "To: receiver@example.com\n\n"
                + "Hello, this is a test email with a Base64 encoded attachment!";
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        String mimeEncodedEmail = mimeEncoder.encodeToString(emailBody.getBytes(StandardCharsets.UTF_8));
        System.out.println("MIME Encoded Email:\n" + mimeEncodedEmail);

        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        String decodedEmail = new String(mimeDecoder.decode(mimeEncodedEmail), StandardCharsets.UTF_8);
        System.out.println("MIME Decoded Email:\n" + decodedEmail);

        // 📌 Ở đây bạn có thể dễ dàng copy mimeEncodedEmail vào nội dung email dạng MIME thực tế!
    }
}
