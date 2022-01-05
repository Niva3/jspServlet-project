package com.Users;
import java.util.*;

public class AddressModel
{
	private List<String> line1 = new ArrayList<String>();
	private List<String> line2 = new ArrayList<String>();
	private List<String> city = new ArrayList<String>();
	private List<String> state = new ArrayList<String>();
	private List<String> country = new ArrayList<String>();
	private List<String> pin = new ArrayList<String>();
	
	public String getLine1(int index)
	{
		return line1.get(index);
	}
	public void setLine1(String line1)
	{
		this.line1.add(line1);
	}
	public String getLine2(int index)
	{
		return line2.get(index);
	}
	public void setLine2(String line2)
	{
		this.line2.add(line2);
	}
	public String getCity(int index)
	{
		return city.get(index);
	}
	public void setCity(String city)
	{
		this.city.add(city);
	}
	public String getState(int index)
	{
		return state.get(index);
	}
	public void setState(String state)
	{
		this.city.add(state);
	}
	public String getCountry(int index)
	{
		return country.get(index);
	}
	public void setCountry(String country)
	{
		this.city.add(country);
	}
	public String getPin(int index)
	{
		return pin.get(index);
	}
	public void setPin(String pin)
	{
		this.city.add(pin);
	}
	
}