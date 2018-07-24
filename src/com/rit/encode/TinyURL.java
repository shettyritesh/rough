package com.rit.encode;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TinyURL {
	public String getTinyURL(String url) {
		Base64.Encoder encoder= Base64.getEncoder();
		return  encoder.encodeToString(url.getBytes(StandardCharsets.UTF_8));


	}
	
	
	public String getURL(String tinyURL) {
		String dencodedString = "";
		Base64.Decoder decoder= Base64.getDecoder();
		byte[] barrauy=decoder.decode(tinyURL);
		String str= new String(barrauy);

		return str;
	}
}
