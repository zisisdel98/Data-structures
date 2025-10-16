import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Experiment {
	public static void main(String[] args) throws IOException{
		Random rand = new Random(); 
		// every text file can coontain up to 1000 folder sizes
		int upperbound = 1001;
		// 3 random numbers of folder sizes
		int n1 = rand.nextInt(upperbound);
		int n2 = rand.nextInt(upperbound);
		int n3 = rand.nextInt(upperbound);
		System.out.println(n1);	  
		System.out.println(n2);	  
		System.out.println(n3);	  
		
	
		File [] files = new File [11];
		
		// create and wirte 10 txt files with names test_N1[j].txt
		// the folders must contain N1 folder sizes with size up to 10^6 
		for (int j = 0; j<11; j++){
			files[j] = new File ("test_N1" + j+ ".txt");
			FileWriter fw = new FileWriter(files[j]);
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i<= n1; i++){
				upperbound = 1000001;
				int x = rand.nextInt(upperbound);
				pw.println(x);
			
			}
			pw.close();
		}
		
		// create and wirte 10 txt files with names test_N2[j].txt
		// the folders must contain N2 folder sizes with size up to 10^6 
		for (int j = 0; j<11; j++){
			files[j] = new File ("test_N2" + j+ ".txt");
			FileWriter fw = new FileWriter(files[j]);
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i<= n2; i++){
				upperbound = 1000001;
				int x = rand.nextInt(upperbound);
				pw.println(x);
			
			}
			pw.close();
		}
		
		// create and wirte 10 txt files with names test_N3[j].txt
		// the folders must contain N3 folder sizes with size up to 10^6 
		for (int j = 0; j<11; j++){
			files[j] = new File ("test_N3" + j+ ".txt");
			FileWriter fw = new FileWriter(files[j]);
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i<= n3; i++){
				upperbound = 1000001;
				int x = rand.nextInt(upperbound);
				pw.println(x);
			
			}
			pw.close();
		}	
		
	}
}