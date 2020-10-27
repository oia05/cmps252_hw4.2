package cmps252.HW4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	public static List<Customer> getCustomers(String FileName) throws FileNotFoundException
	{
		List<Customer> customers= new ArrayList<Customer>();
		Scanner scanner= new Scanner(new File(FileName));
		int linecount=0;
		while(scanner.hasNextLine())
		{
			Customer c;
			
			String line=scanner.nextLine();
			if(linecount==0 || line.isBlank() || line.isEmpty())
			{
				linecount++;
				continue;
			}
			String[] fields= line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			c=new Customer(getRid(fields[0]),getRid(fields[1]),getRid(fields[2]),getRid(fields[3]),getRid(fields[4]),getRid(fields[5]),getRid(fields[6]),getRid(fields[7]),getRid(fields[8]),getRid(fields[9]),getRid(fields[10]),getRid(fields[11]));
			customers.add(c);
		}
		scanner.close();
		return customers;
	}
	
	
	private static String getRid(String s)
	{
		return s.substring(1,s.length()-1);
	}

}