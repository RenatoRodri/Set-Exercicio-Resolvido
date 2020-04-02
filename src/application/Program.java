package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import entities.Log;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter file full path: ");
		
		String Pach = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(Pach))){
			
			Set<Log> set = new HashSet<>();
			
			String line = br.readLine();
			while(line != null) {
				String [] fildes = line.split(" ");
				String username = fildes[0];
				Date moment = Date.from(Instant.parse(fildes[1]));
				
				set.add(new Log(username, moment));
				
				line = br.readLine();
			}
			
			System.out.println("Total user: " + set.size());
		}
		
		catch(IOException e) {
			System.out.println("Erro " + e.getMessage());
		}
		
		sc.close();

	}

}
