package com.v7.ApiTest.Page;

import com.skytesters.framework.Config;
import com.skytesters.keywords.APIKeywords;

public class MemberAPIs_Page {


	public String getUserName()
    {
        String url,username="";
        //pkey = ConfigurationManager.AppSettings["tkey"];
        //ptoken = ConfigurationManager.AppSettings["ttoken"];
        url = Config.APIURL+"1/members/deepaksharma91";
        APIKeywords.initializeRequest(url);
        String response = APIKeywords.sendRequest("get");
        System.out.println("Response : "+response);
        int statuscode = APIKeywords.getStatusCode();
        System.out.println("Status Code : "+statuscode);
        if(!(response.isEmpty()) && statuscode == 200)
        {
        	username = APIKeywords.parseAPIResponse(response,"$.username");
            System.out.println("Username : "+username);
        }
         return (username);
    }
	
	public String getBoardMemberData(int index)
    {
        String url,boardname = "";
        String username = getUserName();
        System.out.println("Username : " + username);
        //execute board api
        url = Config.APIURL + "1/members/" + username + "/boards";
        APIKeywords.initializeRequest(url);
        APIKeywords.setParameter("key", Config.TKEY);
        APIKeywords.setParameter("token", Config.TToken);
        String response = APIKeywords.sendRequest("get");
        System.out.println("Response : "+response);
        int statuscode = APIKeywords.getStatusCode();
        System.out.println("Status Code : "+statuscode);
        if(!(response.isEmpty()) && statuscode == 200)
        {
        	boardname = APIKeywords.parseAPIResponse(response, "$.["+index+"].name");
            System.out.println("Name of Board  " + boardname);
        }
        
        return (boardname);
    }
	
	public String[] getBoardMemberInvalidToken()
    {
        String url;
        String[] result = new String[2];
        String username = getUserName();
        System.out.println("Username : " + username);
        //execute board api
        url = Config.APIURL + "1/members/" + username + "/boards";
        APIKeywords.initializeRequest(url);
        APIKeywords.setParameter("key", Config.TKEY);
        APIKeywords.setParameter("token", Config.ITOKEN);
        String response = APIKeywords.sendRequest("get");
        System.out.println("Response : "+response);
        int statuscode = APIKeywords.getStatusCode();
        System.out.println("Status Code : "+statuscode);
        
        result[0] = response;
        result[1] = statuscode+"";
        return (result);
    }

}
