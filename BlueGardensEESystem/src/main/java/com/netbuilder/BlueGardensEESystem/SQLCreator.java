package com.netbuilder.BlueGardensEESystem;

import com.netbuilder.customannotations.MethodAuthor;

/**
 * 
 * @author gandrews
 *	Generates SQL off of the provided information
 */
public class SQLCreator {

	/**
	 * Creates an instance of an object on a table with given values
	 * @param TableName
	 * The table you want to insert information into
	 * @param Values
	 * The values that the instance will contain
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Create(String TableName, String[] Values)
	{
		String SQL =  "";
		for(String s : Values)
		{
			SQL += s+",";
		}
		//Remove the last comma
		SQL = SQL.substring(0, SQL.length()-1);
		String formattedString = String.format("INSERT INTO %s VALUES (%s);",TableName, SQL);
		
		return formattedString;
	}
	
	/**
	 * Returns the selected columns from a table
	 * @param Table
	 * The table you are wanting to pull information from
	 * @param Columns
	 * The columns you are interested in
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Select(String Table, String[] Columns)
	{
		String SQL = "";
		for(String s : Columns)	
		{
			SQL += s+",";
		}
		//Remove the last comma
		SQL = SQL.substring(0, SQL.length()-1);
		String formattedString = String.format("SELECT %s FROM %s", SQL, Table);
		return  formattedString;
	}
	
	/**
	 * Returns a certain object that matches the criteria from the table name provided 
	 * @param Table
	 * @param IdentifyVariable
	 * The name of the column that you are going to be using as a unique identity
	 * @param IdentityValue
	 * The value of hte unique identity
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Select(String Table, String IdentifyVariable, String IdentityValue)
	{
		String SQL = String.format("SELECT * FROM %s WHERE %s = %s",Table,IdentifyVariable,IdentityValue);
		return SQL;
	}
	
	/**
	 * Returns the entire contents of a table
	 * @param Table
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Select(String Table)
	{
		return "SELECT * FROM " + Table;
	}
	
	/**
	 * Deletes a certain instance from the provided table
	 * @param Table
	 * The name of the table that you wish to delete an instance from
	 * @param identiferName
	 * The identifier you wish to use to select your object (e.g. Name, ID)
	 * @param identifer
	 * The value of the identifier of the item you wish to delete
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Delete(String Table, String identiferName, String identifer)
	{
		String SQL = "DELETE FROM " + Table + " WHERE " + identiferName + " = " + identifer; 
		return SQL;
	}
	
	/**
	 * Updates the select value of the object
	 * @param Table
	 * @param UpdateVariableIdentity
	 * @param UpdateVariable
	 * @param IdentifyingVariable
	 * @param IdentifyingValue
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Update(String Table, String UpdateVariableIdentity, String UpdateVariable, String IdentifyingVariable, String IdentifyingValue)
	{
		String SQL = String.format("UPDATE %s SET %s = %s WHERE %s in (%s)",Table,UpdateVariableIdentity,UpdateVariable,IdentifyingVariable,IdentifyingValue);
		return SQL;
	}
	
	/**
	 * Updates a series of values within a particular instance
	 * @param Table
	 * The table that the item can be located in
	 * @param UpdateVariablesNames
	 * The variabless names that are being updated (e.g. Names,StockLevel,MinimumStock, ext..)
	 * @param UpdateVariableValues
	 * The actual values of the variables that are being updated (e.g. "Gnome5000, 10,9,ext..)
	 * @param IdentifyingName
	 * The name of the column that will be used to track down and specify this particular item
	 * @param IdentifyingValue
	 * The value that will be used to identify the object being updated
	 * @return
	 */
	@MethodAuthor (name = "GAndrews")
	public static String Update(String Table, String[] UpdateVariablesNames, String[] UpdateVariableValues, String IdentifyingName, String IdentifyingValue)
	{
		String set = "";
		for(int i = 0; i <UpdateVariablesNames.length;i++)
		{
			set += UpdateVariablesNames[i]+"="+UpdateVariableValues[i]+",";
		}
		//Remove the last comma
		set = set.substring(0, set.length()-1);
		
		String formattedString = String.format("UPDATE %s SET %s WHERE %s=%s",Table,set,IdentifyingName,IdentifyingValue);
		return formattedString;
	}
}
