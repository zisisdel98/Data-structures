import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;


public class GvsG2 {
    public static void main(String[] args) throws FileNotFoundException{
		
		System.out.println ("Give the path of the files that created with experiment");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		// For N1 
		int sumN1_g = 0;
		int sumN1_g2 = 0;
		for (int i = 0; i<11; i++ ){
			String path = inputString +"\test_N1"+Integer.toString(i) ;
			String[] strArray = new String[] {path};
			Greedy.main(strArray);
			Greedy N = new Greedy();
			sumN1_g += N.numberOfDisks;
			Greedy2.main(strArray);
			Greedy2 N2 = new Greedy2();
			sumN1_g2 += N2.numberOfDisks2;
		}
		double avg_g = sumN1_g/10;
		double avg_g2 = sumN1_g2/10;
		System.out.println ("For the N1 number "+"\n"+ " For greedy algorithm used in average :" + avg_g + "Disks") ;
		System.out.println ("/n"+ " For greedy2 algorithm used in average :" + avg_g2 + "Disks");
		
		//N2
		int sumN2_g = 0;
		int sumN2_g2 = 0;
		for (int i = 0; i<11; i++ ){
			String path = inputString +"\test_N2"+Integer.toString(i) ;
			String[] strArray = new String[] {path};
			Greedy.main(strArray);
			Greedy N_2= new Greedy();
			sumN2_g += N_2.numberOfDisks;
			Greedy2.main(strArray);
			Greedy2 N2_2 = new Greedy2();
			sumN2_g2 += N2_2.numberOfDisks2;
		}
		avg_g = sumN2_g/10;
		avg_g2 = sumN2_g2/10;
		System.out.println ("For the N2 number "+"\n"+ " For greedy algorithm used in average :" + avg_g + "Disks") ;
		System.out.println ("/n"+ " For greedy2 algorithm used in average :" + avg_g2 + "Disks");
		
		
		//N3
		
		int sumN3_g = 0;
		int sumN3_g2 = 0;
		for (int i = 0; i<11; i++ ){
			String path = inputString +"\test_N2"+Integer.toString(i) ;
			String[] strArray = new String[] {path};
			Greedy.main(strArray);
			Greedy N_3= new Greedy();
			sumN3_g += N_3.numberOfDisks;
			Greedy2.main(strArray);
			Greedy2 N3_2 = new Greedy2();
			sumN3_g2 += N3_2.numberOfDisks2;
		}
		avg_g = sumN3_g/10;
		avg_g2 = sumN3_g2/10;
		System.out.println ("For the N3 number "+"\n"+ " For greedy algorithm used in average :" + avg_g + "Disks") ;
		System.out.println ("/n"+ " For greedy2 algorithm used in average :" + avg_g2 + "Disks");
		
		
	}
		
}