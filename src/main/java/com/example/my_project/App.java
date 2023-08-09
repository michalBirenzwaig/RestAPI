package com.example.my_project;


import com.example.my_project.WorkerApiClient.Worker;
/**
 * Hello world!
 *
 */


public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
    System.out.print("ffffff");
     WorkerApiClient workerApiClient=new WorkerApiClient();
     Worker worker=new Worker("1111111111","TESNET","20000",30);
     workerApiClient.addNewWorker(worker);
    }
}
