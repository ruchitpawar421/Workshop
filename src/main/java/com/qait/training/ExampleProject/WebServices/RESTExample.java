package com.qait.training.ExampleProject.WebServices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class RESTExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		postRequestAuthToken();
	}

	public static void getRequest() {
		try {
			String url = "http://www.google.com/search?q=httpClient";

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			// request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void postRequestAuthToken() {
		try {
			String url = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";

			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);

			// add header
			// post.setHeader("User-Agent", USER_AGENT);

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("client_id", "translatorTestApplication"));
			urlParameters.add(new BasicNameValuePair("client_secret", "FKa0b4/hvCweMLgfu0HIUBhgr6/9mkHW9V5uEqi6L/Q="));
			urlParameters.add(new BasicNameValuePair("scope", "http://api.microsofttranslator.com"));
			urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {
				File file = new File("." + File.separator + "src" + File.separator + "main" + File.separator
						+ "resources" + File.separator + "response-token.json");
				file.createNewFile();

				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				bw.write(result.toString());

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException e) {

				e.printStackTrace();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
