package input.controller;

import input.view.PopupDisplay;
import input.model.Thing;

public class PopupController
{
	private PopupDisplay myPopups;
	private Thing myThing;
	
	public PopupController()
	{
		myPopups = new PopupDisplay();
	}

	public void start()
	{
		String name = myPopups.getAnswer("Type in your name");

		myPopups.displayResponse("You typed in " + name);

		int age;
		String tempAge = myPopups.getAnswer("Type your age");
		if (isInteger(tempAge))
		{
			age = Integer.parseInt(tempAge);
		}
		else
		{
			age = -123456789;
		}

		myPopups.displayResponse("You typed in " + age);

		double weight;
		String tempWeight = myPopups.getAnswer("Type in your weight");
		if (isDouble(tempWeight))
		{
			weight = Double.parseDouble(tempWeight);
		}
		else
		{
			weight = -.999000000999990091;
		}

		myPopups.displayResponse("You typed in " + weight);

		myThing = new Thing(name, age, weight);
	}

	private boolean isInteger(String input)
	{
		boolean isInt = false;

		try
		{
			int validInteger = Integer.parseInt(input);
			isInt = true;
		}
		catch (NumberFormatException error)
		{
			myPopups.displayResponse("You did not type in a valid integer, blame Tobin");
		}

		return isInt;
	}

	private boolean isDouble(String input)
		{
			boolean isDouble = false;
			
			try
			{
				double validDouble = Double.parseDouble(input);
				isDouble = true;
			}
			catch (NumberFormatException error)
			{
				myPopups.displayResponse("You dun screwed it up!!");
			}
			return isDouble;
		}
}