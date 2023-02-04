/*
Validate IP address
*/

/*
* IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
* each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
* Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
*
* IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
* The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334
* is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case
* characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid
* IPv6 address(Omit leading zeros and using upper cases).
* However, we don't replace a consecutive group of zero value with a single empty group using
* two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334
* is an invalid IPv6 address.
* Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
* 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
* */
public class ValidIP {

    public static String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 0) {
            return "Neither";
        }
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPV4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] nums = IP.split("\\.");
        if (nums.length != 4) {
            return false;
        }
        for (String val : nums) {
            // 注意：192.0.0.1这种情况。当子串length>1，这是就不能以0开头。
            if ("".equals(val) || (val.length() > 1 && val.charAt(0) == '0')) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                if (!(val.charAt(i) >= '0' && val.charAt(i) <= '9')) {
                    return false;
                }
            }
            if (Integer.parseInt(val) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIPV6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] nums = IP.toLowerCase().split("\\:");
        if (nums.length != 8) {
            return false;
        }
        for (String val : nums) {
            if (val.length() == 0 || val.length() > 4) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                // 16进制的字母组合的IPV6地址
                if (c < '0' || (c > '9' && c < 'a') || c > 'f') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String args[]) {
        //String IP = ".192.0.0.1";
        //String IP = "192.0.0.1.";
        String IP = "2001:db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(IP));
    }
}
