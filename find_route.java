import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class find_route 
{
	class state_node //Class defining the node 
	{
		String Current_State;
		float path_cost;
		float depth;
		state_node parent; 	 
		
		public state_node(String current_State, float path_cost, float depth, state_node parent) //Constructor of the class 
		{
			Current_State  = current_State;
			this.path_cost = path_cost;
			this.depth     = depth;
			this.parent    = parent;
		}		   		  
	}
	
	
	public static void main(String[] args) throws FileNotFoundException { //main method

		String File            = args[0]; //Input argument given for Input File 
		String Source     	   = args[1]; //Input argument given for Source
		String Destination 	   = args[2]; //Input argument given for Destination
		find_route pathways    = new find_route();
		Scanner In_File   	   = new Scanner(new FileReader(File)); //Scanner to read the text input file
		String new_line        = In_File.nextLine(); 
		ArrayList<String> data = new ArrayList<String>(); //Stores all the data from the file
		
		class Cost_Comparator implements Comparator<state_node> //Comparator class which checks the cost of all nodes in fringe and sorts them
		{

			@Override
			public int compare(state_node arg0, state_node arg1) 
			{
				return Float.compare(arg0.path_cost, arg1.path_cost);
			}

			
		}
		
		while(new_line.equals("END OF INPUT") == false)
		{
			data.add(new_line);
			new_line = In_File.nextLine();
		}

		In_File.close();
		
		state_node Source_state         = pathways. new state_node(Source,0,0,null); //Creates the source state node
		ArrayList<state_node> fringe    = new ArrayList<state_node>(); //Arraylist for the fringe
		ArrayList<String> state_visited = new ArrayList<String>();     //The closed set which stores all the nodes visited.
		fringe.add(Source_state);

		state_node goal_state           = null;
		while (((fringe.isEmpty())     == false) && (goal_state == null) ) //loops until fringe is empty and goal state is null
		{
			state_node present_state = fringe.remove(0); //removes node from fringe and adds to present node
			
			
			if(present_state.Current_State.equals(Destination)) //checks if present state is the destination
			{
				goal_state = present_state;			 
				
			}
			else
			{
				if(state_visited.contains(present_state.Current_State))
				{

				}
				else
				{
					state_visited.add(present_state.Current_State); //adds the node to the state visited
					
					for(int i = 0;i < data.size(); i++)
					{
						if((data.get(i).contains(present_state.Current_State))) //checks if the data list has the present state
						{
							StringTokenizer strToken = new StringTokenizer(data.get(i), " "); //Used to tokenize the string values
							String Start             = strToken.nextToken();
							String End               = strToken.nextToken();

							int Cost                 = Integer.parseInt(strToken.nextToken());
							float float_cost         = (float)Cost;
							if(present_state.Current_State.equals(Start)) //to check if the present state value is present and to choose the connected path state
							{
								state_node next_state = pathways.new state_node(End, float_cost + present_state.path_cost, present_state.depth + 1, present_state);
								fringe.add(next_state);
								
							}
							else 
							{
								state_node next_state = pathways. new state_node(Start, float_cost + present_state.path_cost, present_state.depth + 1, present_state);
								fringe.add(next_state);
							}
						}
					}
					Cost_Comparator Comparator; 
					Comparator = new Cost_Comparator(); 
					
					Collections.sort(fringe, Comparator);//Used to sort the fringe
					
				}
				
			}
		}
		if(goal_state == null)
		{
			System.out.println("distance: infinity"+"\n"+"route:"+"\n"+"none");
		}
		else 
		{
			float final_path_cost = goal_state.path_cost;
			System.out.println("Distance: "+final_path_cost); 
			printcost(goal_state);		//recursive function to print the data		
		}
		
	}
	public static void printcost(state_node print_goal_state)
	{
		if(print_goal_state.parent == null)
		{
			return;
		}
		printcost(print_goal_state.parent);
		
		
		String place1           = print_goal_state.parent.Current_State;
		String place2           = print_goal_state.Current_State;
		float current_path_cost = print_goal_state.path_cost - print_goal_state.parent.path_cost;
		
		
			System.out.println(place1+" to "+place2+" "+current_path_cost);
			
	}
	
}


 
