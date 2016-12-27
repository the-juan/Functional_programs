# Functional_programs
Practical projects that i'm working on.
Scrapeweb.java      : This class has the tools to retrieve the HTML from craigslist's apa category. As of now it works with 
                      any location that does not have derivative locations(for example sfbay has sbay,ebay... therefore it will not work).
scrape_Initialpage(): You can retrieve the initial HTML from sites such as https://santabarbara.craigslist.org/search/apa.
find_Ids()          : This method will find all the posting IDs from the initial site, all 100 of them, and return a 
                      Array of ints. Each value corresponding to the index of first number in the id.  
assemble_URL()      : This method will assemble URLs from the indeces of theposting IDs.
getmore_Html()      : This method will return a Array of Strings, each corresponding to the HTML of an induvidual URL.

Html_parse.java     : This class has the necessary tools to parse the HTML retrieved from Scrapeweb. I'm still working on it but as of now
                      the constructor takes in an Array of Strings and parses the data. I've made it print out the titles and prices 
                      but still needs a work.
                       
                
                
