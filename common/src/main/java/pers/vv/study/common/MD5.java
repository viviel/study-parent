package pers.vv.study.common;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

    public static void main(String[] args) {
        String code = DigestUtils.md5Hex("文和");
        for (int i = 0; i < 99_999_999; i++) {
            code = DigestUtils.md5Hex(code);
        }
        System.out.println(code);
    }

}
