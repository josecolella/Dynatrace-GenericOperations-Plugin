package com.dynatrace.diagnostics.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class ServerRestAPI {
	
	private String dtServer;
	

	private String username;
	private String password;
	private String authString;
	private String authStringEnc;
	private String dashboardName;
	private URL dashboardUrl;
	private HttpURLConnection connection;
	private URL url;
	
	public ServerRestAPI(String dtServer, String username, String password) {
		this.dtServer = dtServer;
		this.username = username;
		this.password = password;
		
		this.authString = this.username + ":" + this.password;
		this.authStringEnc = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary((this.authString).getBytes());
		
	}
	
	public Document getDashboard(String dashboardName) throws IOException, ParserConfigurationException, SAXException {
		this.dashboardUrl = new URL("https://" + this.dtServer + ":8021/rest/management/dashboard/" + URLEncoder.encode(dashboardName,"UTF-8").replace("+", "%20") + "?type=xml");
		this.connection = (HttpURLConnection)this.dashboardUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", authStringEnc);
		
		InputStream in = connection.getInputStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(in);
		
		return doc;
	}
	public String getDtServer() {
		return dtServer;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
