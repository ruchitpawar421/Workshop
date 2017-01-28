package com.qait.training.ExampleProject.WebServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class SOAPExample {

	public static void main(String[] args) {
		try {

			// Creating the HttpURLConnection object
			URL oURL = new URL("http://www.dneonline.com/calculator.asmx?op=Add");

			HttpURLConnection con = (HttpURLConnection) oURL.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "application/soap+xml; charset=utf-8");
			con.setDoOutput(true);
			con.setDoInput(true);

			// Reading the SOAP request message from a file
			File objFile = new File("." + File.separator + "src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "request.xml");
			int reqLen = (int) objFile.length();
			byte[] reqBytes = new byte[reqLen];
			FileInputStream inStream = new FileInputStream(objFile);
			inStream.read(reqBytes);
			inStream.close();

			// Posting the SOAP request XML message
			OutputStream reqStream = con.getOutputStream();
			reqStream.write(reqBytes);
			reqStream.flush();

			// Reading the SOAP response XML message
			byte[] byteBuf = new byte[1024];
			File file = new File("." + File.separator + "src" + File.separator + "main" + File.separator + "resources"
					+ File.separator + "response.xml");
			file.createNewFile();
			FileOutputStream outStream = new FileOutputStream(file);
			InputStream resStream = con.getInputStream();
			int resLen = 0;
			int len = resStream.read(byteBuf);
			while (len > -1) {
				resLen += len;
				outStream.write(byteBuf, 0, len);
				len = resStream.read(byteBuf);
			}
			outStream.close();

			reqStream.close();
			resStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
