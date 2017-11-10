package xgsHt;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class javaTest {
	public static void main(String args[]){
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer("5a0fbd2c7361dc11b05cd08cf18dcfba");
			System.out.println(new String(b,"UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
