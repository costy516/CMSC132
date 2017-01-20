package student_classes;
import java.net.*;
import java.io.*;

public class Crawler {
	
	
	public static void main(String[] args) 
    {
		
		MyQueue<URL> linkQueue = new MyQueue<URL>();
		MyQueue<URL> picQueue = new MyQueue<URL>();
		MySet<URL> beenThere = new MySet<URL>();
		MySet<URL> doneThat = new MySet<URL>();
		
		boolean foundOne = false;
			
		final int MAX_NUM_EXTRACTORS = 5;  // Change this to whatever you want
			
		ExtractorThread[] extractors = new ExtractorThread[MAX_NUM_EXTRACTORS];
			
		new SlideShowGUI(picQueue);
		new CrawlerGUI(linkQueue, picQueue, beenThere, doneThat, extractors);
			
		URL next = null;
		
		//Consumer
		while(true) 
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			for(int i = 0; i < extractors.length; i++)
			{
				if(extractors[i] == null || !extractors[i].isAlive())
				{
					synchronized(linkQueue)
					{
						while(linkQueue.isEmpty())
						{
							try {
								linkQueue.wait();
							} catch (InterruptedException e) {
								
							}
						}
					}
					synchronized(extractors)
					{
						try
						{	
							//extractors.wait();
							while(!foundOne)
							{
								next = linkQueue.dequeue();
								URLConnection test = next.openConnection();
								if(test.getContentType() != null && test.getContentType().length() >= 9 && test.getContentType().substring(0, 9).equals("text/html"))
								{
									foundOne = true;
								}
							}
							System.out.println("URL: " + next.toString());
							extractors[i] = new ExtractorThread(next, linkQueue, picQueue, beenThere, doneThat);
							extractors[i].start();
							foundOne = false;
						}catch(Exception e){
							//ignore
						}
					}
				}
			}
		}
    }
}
