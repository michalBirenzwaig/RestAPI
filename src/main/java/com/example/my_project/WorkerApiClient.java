
package com.example.my_project;
import com.google.gson.Gson;
import okhttp3.*;

public class WorkerApiClient {

	    private static final String API_BASE_URL = "https://dummy.restapiexample.com";
	    private static final Gson gson = new Gson();

	    @SuppressWarnings("deprecation")
		public static void addNewWorker(Worker worker) throws Exception {
	        OkHttpClient httpClient = new OkHttpClient();

	        String url = API_BASE_URL + "/get";
	        String jsonRequestBody = gson.toJson(worker);

	        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonRequestBody);
	        Request request = new Request.Builder()
	                .url(url)
	                .post(body)
	                .build();

	        try (Response response = httpClient.newCall(request).execute()) {
	            if (!response.isSuccessful()) {
	                throw new Exception("Failed to add worker: " + response);
	            }
	        }
	    }

	    // Your Worker class should match the API's worker data structure
	    public static class Worker {
	    	public Worker(String string, String string2, String string3, int i) {
				// TODO Auto-generated constructor stub
			}
			private String ID;
	        private String name;
	        private String salary;
	        private int age;
	        
	        // Constructor, getters, setters, etc.
	    }
	}
