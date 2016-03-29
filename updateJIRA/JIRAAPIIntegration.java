package updateJIRA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

public class JIRAAPIIntegration {
	
	public void updateIssue(String id, String testCaseName){
		
		try {
			
			String credentials = "Louisa_samuel@infosys.com" + ":" + "jira@123";
			BASE64Encoder encoder = new BASE64Encoder();
			String encoding = encoder.encode(credentials.getBytes("UTF-8"));
			
			URL url = new URL("http://10.66.38.52:8081/rest/api/2/issue/"+testCaseName+"/transitions?expand=transitions.fields");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Authorization", String.format("Basic %s", encoding));
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"transition\": {\"id\":\""+id+"\"}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Post Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
		
	}
	
	public CreateIssue createIssue(String projId, String issueType, String summary){
		
		CreateIssue issue = new CreateIssue();
		
		try {
			
			String credentials = "Louisa_samuel@infosys.com" + ":" + "jira@123";
			BASE64Encoder encoder = new BASE64Encoder();
			String encoding = encoder.encode(credentials.getBytes("UTF-8"));
			
			URL url = new URL("http://10.66.38.52:8081/rest/api/2/issue");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Authorization", String.format("Basic %s", encoding));
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String inputJSON = "{\"fields\": {\"project\":{\"id\":\""+projId+"\"},\"summary\": \""+summary+"\",\"issuetype\": {\"name\":\""+issueType+"\"}}}";

			OutputStream os = conn.getOutputStream();
			os.write(inputJSON.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			StringBuilder sb = new StringBuilder();
			System.out.println("Post Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			JSONObject jsonObj = JSONObject.fromObject(sb.toString());
			
			
			issue.setId(jsonObj.getString("id"));
			issue.setKey(jsonObj.getString("key"));
			issue.setSelf(jsonObj.getString("self"));
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
		
		return issue;
		
	}
	
	
	
	public Transitions getTransitions(String testCaseName){
		Transitions transitions = new Transitions();
		
		 try {
			 	StringBuilder sb = new StringBuilder();
			 	
			 	String credentials = "Louisa_samuel@infosys.com" + ":" + "jira@123";
			 	BASE64Encoder encoder = new BASE64Encoder();
				String encoding = encoder.encode(credentials.getBytes("UTF-8"));
				
				URL url = new URL("http://10.66.38.52:8081/rest/api/2/issue/"+testCaseName+"/transitions");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				conn.setRequestProperty("Authorization", String.format("Basic %s", encoding));
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					
					sb.append(output);

				}
				
		        JSONObject jsonObj = JSONObject.fromObject(sb.toString());
		        JSONArray jsonArry = JSONArray.fromObject(jsonObj.get("transitions"));
		        
		        for(int i = 0; i < jsonArry.size(); i++) {
		        	
		        	if(JSONObject.fromObject(jsonArry.get(i)).get("name").equals("Done")){
		            	String id = JSONObject.fromObject(jsonArry.get(i)).get("id").toString();
		            	updateIssue(id, testCaseName);
		            }
		            
		        }
		        
				System.out.println("JSON "+sb.toString());
				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		
		return transitions;
	}
	
	public static void main(String[] args){
		
		JIRAAPIIntegration integration = new JIRAAPIIntegration();
		String testCaseName="TES-4";
		
		String id="10000";
		String issueType="Bug";
		String summary = "Testing";
		
		integration.getTransitions(testCaseName);
		
		integration.createIssue(id, issueType, summary);

	}

}
