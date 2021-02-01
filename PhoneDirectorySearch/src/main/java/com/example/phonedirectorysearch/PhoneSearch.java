package com.example.phonedirectorysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Search the phone directory and results the pattern matched in the request.
 */
public class PhoneSearch {

	private String[] dataString = {"srikanth", "sandesh", "rajesh", "rakesh", "chandru", "chethan", "akash", "adesh", "kiran", "karthik"};
	private List<String> searchString;
	private String emptyString;
	
	/**
     * Search the phone directory and results the pattern matched in the request.
     * @param searchString
     *            The {@link String}. 
     * @return The matched {@link ArrayList} of string.            
     */
	public List<String> searchDirectory(String searchString)
	{
		final List<String> resulString = new ArrayList<>();
		
		for(int i=0; i< searchString.length() ; i++)
		{
			// Add the resultant data if it matches the first char from all the data. -- START 
			if(resulString.isEmpty())
			{
				for(int j=0; j< dataString.length; j++)
				{
					if(dataString[j].charAt(i) == searchString.charAt(i))
					{
							resulString.add(dataString[j]);
					}
				}
			}
			// Add the resultant data if it matches the first char from all the data. -- END
			// From the resultant data I am further checking the subsequent string if not there we will remove from result data with the pattern request -- START
			else
			{
				final List<String> tempString = new ArrayList<>();
				
				resulString.forEach(str -> tempString.add(str));
				
				for(int j=0; j< tempString.size(); j++)
				{
					if(tempString.get(j).charAt(i) != searchString.charAt(i))
					{
						resulString.remove(tempString.get(j));
					}
				}
				
			}
			// From the resultant data I am further checking the subsequent string if not there we will remove from result data with the pattern request -- END
		}
		
		return resulString;
	}

	/**
     * @return The string.            
     */
	public List<String> getSearchString() {
		return searchString;
	}

	/**
     * Sets the string which is passed.            
     */
	public void setSearchString(List<String> searchString) {
		this.searchString = searchString;
	}
	
	/**
     * @return The string.            
     */
	public String getEmptyString()
	{
		return emptyString; 
	}
	
	/**
     * Sets the string which is passed.            
     */
	public void setEmptyString(String emptyString)
	{
		this.emptyString = emptyString; 
	}
}
