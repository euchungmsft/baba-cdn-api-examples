package com.eg.baba.cdn.examples;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeCdnDomainBaseDetailRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeCdnDomainDetailRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeCdnDomainLogsRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeCdnMonitorDataRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeCdnMonitorDataResponse;
import com.aliyuncs.cdn.model.v20141111.DescribeDomainBpsDataRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeDomainRegionDataRequest;
import com.aliyuncs.cdn.model.v20141111.DescribeDomainRegionDataResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main main = new Main();
		main.perform();
		
	}

	private String entry;
	private String key;
	private String secret;
	
	String domain = "subdomain.acme.com";
	
	Main(){
		this.entry = ClientProfile.getEntry();
		this.key = ClientProfile.getKeyId();
		this.secret = ClientProfile.getKeySecret();
	}

	private void perform() {
		// TODO Auto-generated method stub
		
		IClientProfile profile = DefaultProfile.getProfile(entry, key, secret);
		IAcsClient client = new DefaultAcsClient(profile);

//		DescribeCdnDomainBaseDetailRequest req = new DescribeCdnDomainBaseDetailRequest();
//		req.setDomainName(domain);
//		sendRecv(client, req);

//		DescribeCdnDomainDetailRequest req = new DescribeCdnDomainDetailRequest();
//		req.setDomainName(domain);
//		sendRecv(client, req);
		
//		DescribeCdnMonitorDataRequest req = new DescribeCdnMonitorDataRequest();
//		req.setDomainName(domain);
//		req.setStartTime("2017-07-09T15:00:00Z");
//		req.setEndTime("2017-07-10T17:00:00Z");
//		sendRecv(client, req);

//		DescribeDomainBpsDataRequest req = new DescribeDomainBpsDataRequest();
//		req.setDomainName(domain);
//		sendRecv(client, req);
//		
//		DescribeDomainRegionDataRequest req = new DescribeDomainRegionDataRequest();
//		req.setDomainName(domain);
//		req.setStartTime("2017-07-10");
//		req.setEndTime("2017-07-10");
//		sendRecv(client, req);

		DescribeCdnDomainLogsRequest req = new DescribeCdnDomainLogsRequest();
		req.setDomainName(domain);
		req.setStartTime("2017-07-10T15:00:00Z");
		req.setEndTime("2017-07-10T16:00:00Z");		
		sendRecv(client, req);

	}

	private void sendRecv(IAcsClient client, RpcAcsRequest req) {
		// TODO Auto-generated method stub
		
		try {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(client.getAcsResponse(req), System.out);
			
			
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
