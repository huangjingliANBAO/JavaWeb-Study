import java.security.MessageDigest;

/**
 * MD5加密
 * 2019.08.01
 */
public class Test {
    public static void main(String[] args)throws Exception {
            String plainText = "123456";
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] cipherData = md5.digest(plainText.getBytes());
            StringBuilder builder = new StringBuilder();
            for(byte cipher : cipherData) {
                String toHexStr = Integer.toHexString(cipher & 0xff);
                builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
            }
            System.out.println(builder.toString());
    }
}
