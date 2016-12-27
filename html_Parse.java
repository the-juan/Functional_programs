import java.util.Arrays;
public class html_Parse {

	public html_Parse(String[] a) {
	String[] innerlink_html = new String[a.length];
	String [] prices = new String[a.length];
	String[] titles= new String[a.length] ;
	innerlink_html=a;
	///////////////Get all the titles
	int titlestart=0;int titleend=0;int i;
	for( i=0;i<100;i++){
				titlestart = innerlink_html[i].indexOf("<title>");
				titlestart = titlestart+ 7;
				titleend=innerlink_html[i].indexOf("</title>");
				titles[i]=innerlink_html[i].substring(titlestart,titleend);
	}
	System.out.println(Arrays.toString(titles)); 
	/////Gets the prices from the Strings in the innerlink_html array
	int found2; String temp ; int found = 0;
	for(i=0; i<100; i++){
		 found=0;
		 found = innerlink_html[i].indexOf("<span class=\"price\">");
		 found =found + 21;
			try{
				 found2 = innerlink_html[i].indexOf("</span> <span class=\"ho");
				 if(found2==-1){
				 	   found2 = innerlink_html[i].indexOf("</span> <span id=\"");
				 }
				 prices[i]=innerlink_html[i].substring(found, found2);
			}
		    catch(Exception e){
			     prices[i]="none";
			}
	}
		System.out.println(Arrays.toString(prices));
	
	}
}
