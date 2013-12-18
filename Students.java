
import java.io.*;
import java.awt.*;
import java.util.*;

public class Students {
	private static String[] studentss;
	public static void main(String[] args){
		
		String[] students;
		String path;
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the path of the list of students.");
		path = s.nextLine();
		students = loadFile(path, studentss);
		System.out.println("Press 1 to choose a random student.");
		System.out.println("Press 2 to choose a group of students.");
		int num = s.nextInt();
		
		
		shuffle(students);
		
		if (num == 1) {
			System.out.println(students[0]);
		}
		if (num == 2) {
			System.out.println("How many people in each group?");
			int groupNum = s.nextInt();
			int name = 0;
			
			for (int i = 0; i<students.length; i++) {
				for (int x = 0; x<groupNum; x++) {
					if (groupNum >= 17 && groupNum <= students.length) {
						groupNum = 16;
					} else if(groupNum > students.length){
						System.out.println("There are not that many people in the class.");
						System.exit(1);
					}
					System.out.println(students[name]);
					name++;
					if (name == students.length) {
						System.exit(1);
					}
				}
				System.out.println();
				
			}
			
		}
	}
	public static void shuffle(String[] students) {
		Random r = new Random();
		for (int i = students.length-1; i>0; i--) {
			String a = students[i];
			int temp = r.nextInt(i);
			students[i] = students[temp];
			students[temp] = a;
		}
		
	}
	public static String[] loadFile(String path, String[] student) {

		
		File a = new File(path);
		Scanner scan;
		
		try {
			scan = new Scanner(a);
			student = scan.nextLine().split(",");
		} catch(FileNotFoundException e) {
			System.out.println("Could not load file at path: " + path);
			System.exit(1);
		}
		return student;
		
	}
}