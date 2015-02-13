import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class text_processing
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		
		String text; 
		String input_location = "/home/matthias/Dropbox/Work/Code/character_component_scraper/character_component_scraper_items.csv";
		BufferedReader br = new BufferedReader(new FileReader( input_location ));

		while ((text = br.readLine()) != null) 
		{
			
			//the main character
			Pattern pat_0 = Pattern.compile( "『(.*?)』" );
			Matcher mat_0 = pat_0.matcher( text );
			if( mat_0.find() )
			{
			    System.out.println("\n" + mat_0.group(1) );
			    
			}
			//the pin yin
			Pattern pat_1 = Pattern.compile("class=\"\"pinyin\"\">(.*?)<script>(?:(?!<script>).)*");
			Matcher mat_1 = pat_1.matcher( text );
			if( mat_1.find() )
			{
			    System.out.println( mat_1.group(1) );
			}
			//the ubiquitous radical 
			Pattern pat_2 = Pattern.compile( "<span class=\"\"b\"\">部首：</span>" ); 
			Matcher mat_2 = pat_2.matcher( text );
			if( mat_2.find() )
			{
			    Pattern pat_3 = Pattern.compile("<span class=\"\"b\"\">部首：</span>(.*?)<span class=\"\"b\"\">");
			    Matcher mat_3 = pat_3.matcher( text );
			    if( mat_3.find() )
				{
			    	System.out.println("部首：" + mat_3.group(1) );
				}

			}
			else
			{
				//simple rad (简体)
				Pattern pat_5 = Pattern.compile("简体部首：</span>(.*?)<span class=\"\"b\"\">");
			    Matcher mat_5 = pat_5.matcher( text );
			    if( mat_5.find() )
				{
			    	System.out.println("部首：" + mat_5.group(1) );
				
				}
			    

			}
			
			//the decomposition
			Pattern pat_9 = Pattern.compile("#################,\" ]：(.*?)\\(");
			Matcher mat_9 = pat_9.matcher( text );
			if( mat_9.find() )
			{
			    System.out.println("首尾分解: " + mat_9.group(1) );
			}

		}
		
		
	}
}


			   