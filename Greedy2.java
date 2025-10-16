import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class Greedy2 {
	public static int numberOfDisks2 =0;
	static void merge(Folder arr[], int l, int m, int r)
	{

		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		Folder L[] = new Folder[n1];
		Folder R[] = new Folder[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		
		int i = 0, j = 0;


		int k = l;
		while (i < n1 && j < n2) {
			if (L[i].getSize() >= R[j].getSize()) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}


		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}


		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}


	static void sort(Folder arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);
			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}



	
	public static void main(String[] args){
		try {
		String path = args [0]; 
		int num_of_lines=1; 		
		try {
		File fi=new File(path);    
		FileReader fr=new FileReader(fi); 
		BufferedReader br = new BufferedReader(fr);            
		while(br.readLine()!=null) 
		{
			br.readLine();
			num_of_lines++;       
		}
		fr.close();
		} catch (IOException io){
			io.printStackTrace();
		}
		Scanner scanner = new Scanner(new File(path)); 		
		Folder [] f = new Folder [num_of_lines+1];
		int j=0;
		while(scanner.hasNextLine()) 
		{
			String row1 = scanner.nextLine();
			int test = Integer.parseInt(row1);
			if (j<=num_of_lines){
				f[j]=new Folder(test); 
			}
			j +=1 ;
		}
		scanner.close();
		sort (f,0,f.length-1);
		MaxPQ <Disk> pq = new MaxPQ <> (new DiskComparator());
		int id = 0 ;
		boolean breaker = false; // flag for wrong numbers
		j =0; //pointer for table folders
		int k =0; //pointer for table Disks			
		Disk [] myDisk = new Disk [num_of_lines];
		while (j<= num_of_lines){
			if (pq.get_the_size() == 0 ){
				myDisk[k]= new Disk(id+=1);
				myDisk[k].setIndex(k);
				if (myDisk[k].check_for_space(f[j])){
					myDisk[k].addInDisk(f[j]);
					f[j].setSavedDisk(myDisk[k].getId());
					pq.add (myDisk[k]);

				}
			} else { 
					// find the disk with max freespace
					Disk temp = pq.peek();
					int tempIndexDisk= temp.getIndex();					
					if (myDisk[tempIndexDisk].check_for_space(f[j])){
						myDisk[tempIndexDisk].addInDisk(f[j]);
						f[j].setSavedDisk(myDisk[tempIndexDisk].getId());
						int tempIndex = pq.getIndex();
						pq.modify(tempIndex, myDisk[tempIndexDisk]);

					} else{
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
			
			// Output
			if (breaker == true){
				System.out.println ("Extremely Big Folders, the size must be between 0 and 1.000.000");
			}else{
				System.out.println(" %java Greedy" + path);
				System.out.println ("Total number of Disks used = " + (k+1));
				numberOfDisks2 = k+1;
				

				if (num_of_lines <=100){
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
		

