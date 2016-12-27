
import java.util.Arrays;
import java.util.Scanner;

import com.jaunt.JauntException;
import com.jaunt.UserAgent;
 public class Scrapeweb {
private String inputstr;
private String docc;///original html
///////////data attained from initial html page
private String [] full_url = new String[100];
private int [] index;///indeces of ids
private String [] innerlink_html = new String[100];
private String [] titles = new String[100];
private String [] prices = new String[100];
private String [] body = new String[100];
private String [] image_links = new String[100];

/////Inputs parameters, work on later...
	public String Inputword() {	
		Scanner scan = new Scanner(System.in);
		inputstr = scan.nextLine();
		return inputstr;
	}
	
//////Retrieves the html of the main Craigslist apa page///works with any craigslist location excep those that have sub_locals
	public void scrape_initialpage(){									///////////////For example Sfbay has sbay,ebay,etc
		try{
			  UserAgent userAgent = new UserAgent();                       
			  userAgent.visit("https://santabarbara.craigslist.org/search/apa");  		  docc = userAgent.doc.innerHTML();
			  String upToNCharacters = docc.substring(0, Math.min(docc.length(), 150000));
		}		
		catch(JauntException e){
			  System.err.println(e);
		}
	} 
	
///// makes an array filled with the indexes of posting ids
	public int[] find_Ids(){
		int start=0;int count=0;int i=0;index= new int [100];//public int [] index;
		  while (true) {  //Count and document indeces of matches
		    int found = docc.indexOf(".html\" data-id=\"", start);// string to looks for
		     if (found != -1) {
		      index[i]=found; 
		      i=i+1;
		      count=count+1;
		    }
		     if (found == -1) break;
		      start = found + 1280;  // 
		  }
		System.out.println(count); // print the count the number of occurances
		System.out.println(Arrays.toString(index));//print out Array of indices that contain string
		System.out.println(docc.substring(index[1]+16	,index[1]+26));//substring of all ids
		return index;
	}
	
/////puts together the full url using the ids retrieved from find_Ids()
	public void assemble_URL(){
		String beg_url="https://santabarbara.craigslist.org/apa/";
		String end_url=".html";
		for (int i = 0; i<100; i++){
			full_url[i]= beg_url + docc.substring(index[i]+16,index[i]+26) + end_url;
			docc.substring(index[1]+16	,index[1]+26);	
		}
		System.out.println(Arrays.toString(full_url));		
	}
	
/////This retrieves the html from all the ads inside the main apa page and puts them in the
/////array innerlink_html
	private String[] Getmore_html(){                 
		for (int i = 0; i<100; i++ ){
			try{
			  UserAgent userAgent = new UserAgent();                       
			  userAgent.visit("https://santabarbara.craigslist.org/apa/"+docc.substring(index[i]+16,index[i]+26)+".html");
			  innerlink_html[i] = userAgent.doc.innerHTML();
			  }
			catch(JauntException e){
			  System.err.println(e);
			}
		}
		System.out.println("======================================");
		return innerlink_html;
	}
		
	public static void main(String[] args){	
		String[] x;
		Scrapeweb one = new Scrapeweb();
	    one.scrape_initialpage();
	    one.find_Ids();
	    one.assemble_URL();
	    x=one.Getmore_html();
	    html_Parse two = new html_Parse(x); 
	}

}


