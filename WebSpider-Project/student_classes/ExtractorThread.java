package student_classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class ExtractorThread extends Thread {
    
	private URL url;
	private MyQueue<URL> linkQueue, picQueue;
	private MySet<URL> beenThere, doneThat;

	public ExtractorThread(URL url, MyQueue<URL> linkQueue, MyQueue<URL> picQueue, MySet<URL> beenThere, MySet<URL> doneThat) {
		this.url = url;
		this.linkQueue = linkQueue;
		this.picQueue = picQueue;
		this.beenThere = beenThere;
		this.doneThat = doneThat;
	}

	public String getCurrentURL() {
		return url.toString();
	}

	private static Pattern LINK_PATTERN = Pattern.compile("href *= *\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
	private static Pattern IMAGE_PATTERN = Pattern.compile("<( )*(img|IMG)( )+([^<>])*(src|SRC)( )*=( )*\"([^\"]+)\"[^>]*>");

	private static Set<URL> extractLinks(Pattern toMatch, String s, URL currentURL, int group) {
		Matcher m = toMatch.matcher(s);
		Set<URL> links = new HashSet<URL>();
		while ( m != null && s!= null && m.find()) {
			String found = m.group(group);
			try {
				links.add(new URL(currentURL, found));
			} catch (MalformedURLException e) {
				// just ignore
			}
		}
		return links;
	}

	private static Set<URL> getLinks(String s, URL currentURL) {
		return extractLinks(LINK_PATTERN, s, currentURL, 1);
	}

	private static Set<URL> getPicURLs(String s, URL currentURL) {
		return extractLinks(IMAGE_PATTERN, s, currentURL, 8);
	}
	
	//Producer
	public void run()
	{	
		try
		{
			
			BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()));
			
			String inputLine = null;
			
			while((inputLine = in.readLine()) != null)
			{
				Set<URL> linksToAdd = getLinks(inputLine, url);
				for(URL url: linksToAdd)
				{
					if(url != null && (url.getProtocol().substring(0, 4).equals("file") || url.getProtocol().substring(0, 4).equals("http")) 
							&& !beenThere.contains(url))
					{
						linkQueue.enqueue(url);
						beenThere.add(url);
					}
				}
				inputLine = in.readLine();
			}
			
			
			in.close();
			
			in = new BufferedReader(new InputStreamReader(this.url.openStream()));
			
			inputLine = null;
			synchronized(picQueue){
				while((inputLine = in.readLine()) != null)
				{
					Set<URL> picsToAdd = getPicURLs(inputLine, url);
					for(URL url: picsToAdd)
					{
						if(url != null && (url.getProtocol().substring(0, 4).equals("file") || url.getProtocol().substring(0, 4).equals("http"))
								&& !doneThat.contains(url))
						{
							picQueue.enqueue(url);
							doneThat.add(url);
						}
					}
					inputLine = in.readLine();
				}
			}
			in.close();
		}catch (IOException e)
		{
			//ignore
		}
	}

}
