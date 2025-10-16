import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class Greedy {
	public static int numberOfDisks =0;
	public static void main(String[] args) throws FileNotFoundException{
		try {
		String path = args [0]; 
		// how many folders in the file.txt
		int num_of_lines=0; 
		try {
		File fi=new File(path);    
		FileReader fr=new FileReader(fi); 
		BufferedReader br = new BufferedReader(fr);
		// find the number of folders
		while(br.readLine()!=null) 
		{
			num_of_lines++;       
		}
		fr.close();
		} catch (IOException io){
			io.printStackTrace();
		}
		Scanner scanner = new Scanner(new File(path));
		MaxPQ <Disk> pq = new MaxPQ <> (new DiskComparator());
		// init the ids
		int id = 0 ;
		boolean breaker = false; // flag for wrong numbers
		int j =0; //pointer for table folders
		int k =0; //pointer for table Disks			
		Folder [] f = new Folder [num_of_lines];
		Disk [] myDisk = new Disk [num_of_lines];
		while (scanner.hasNextLine()){
			// in each row -> capacity of each folder
			String row1 = scanner.nextLine();
			int i = Integer.parseInt(row1);
			// if the size is out of limits STOP
			if (i <0 || i>1000000){
				breaker = true;
				break;
			}
			// if the queue is empty
			if (pq.get_the_size() == 0 ){
				f[j] = new Folder (i);
				myDisk[k]= new Disk(id+=1);
				myDisk[k].setIndex(k);
				if (myDisk[k].check_for_space(f[j])){
					myDisk[k].addInDisk(f[j]);
					f[j].setSavedDisk(myDisk[k].getId());
					pq.add (myDisk[k]);

				}
				//else if its not empty
			} else { 
					// find the disk with max freespace
					Disk temp = pq.peek();
					// find the index of max Disk
					int tempIndexDisk= temp.getIndex();
					f[j] = new Folder (i);
					if (myDisk[tempIndexDisk].check_for_space(f[j])){
						myDisk[tempIndexDisk].addInDisk(f[j]);
						f[j].setSavedDisk(myDisk[tempIndexDisk].getId());
						int tempIndex = pq.peek().getIndex();
						pq.modify(tempIndex, myDisk[tempIndexDisk]);

					} else{ // if the space is not enough create new Disk
						k+=1;

						myDisk[k]= new Disk(id+=1);
						myDisk[k].check_for_space(f[j]);
						myDisk[k].setIndex(k);
						myDisk[k].addInDisk(f[j]);
						f[j].setSavedDisk(myDisk[k].getId());
						pq.add(myDisk[k]);
						
					} 
						
				}
				j+=1;	
			}
			
			scanner.close();
			// Output
			if (breaker == true){
				System.out.println ("Extremely Big Folders, the size must be between 0 and 1.000.000");
			}else{
				System.out.println(" %java Greedy" + path);
				System.out.println ("Total number of Disks used = " + (k+1));
				numberOfDisks= k+1;

				if (num_of_lines <= 100){
					// for each Disk Sort the folders that contains
					for (int i= 0; i<=k; i++){
						int l=0;
						int [] capacities = new int [num_of_lines];
						for (int v = 0; v< f.length ; v++)
							if (myDisk[i].getId() == f[v].getSavedDisk()){
								capacities[l]= f[v].getSize();
								l+=1;
							}
						for(int w = 1; w < capacities.length; w++) {
							int h = w;
							while(h > 0 && capacities[h] < capacities[h-1]) {
								int temp = capacities[h];
								capacities[h] = capacities[h-1];
								capacities[h-1] = temp;
								h--;
							}
						}
						System.out.println ("\n"+" ID : " + pq.peek().getId() + " has "+ pq.getMax().getFreeSpace() +" MB free space and the saved folders have sizes :");
						for(int w = 0; w < capacities.length; w++){
							if (capacities[w]>0){
								System.out.print( " "+ capacities[w]);
							}
						}
						
					}
				} else {
					for (int i= 0; i<=k; i++){
						System.out.println ("\n"+" ID : " + pq.peek().getId() + " has "+ pq.getMax().getFreeSpace() +" MB free space");
					}
				}
			}
		

		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
	}
}
		

