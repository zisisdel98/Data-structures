import java.io.*;
import java.util.*;
public class Disk implements Comparable <Disk> {
	
	private int size;
	private int id;
	private int index;
	List <Folder> folders = new List<Folder> ();
	//constructor
	Disk (int id){
		this.size = 1000000;  //mb
		this.id=id;
	}
	// return the rest FreeSpace
	public int getFreeSpace(){
		return size;
	}
	
	// used only from Disks and reduce the space
	private void reduce (int space){
		this.size = this.size-space;
	}
	
	// checks for freespace and if is enough reduce()
	public boolean check_for_space(Folder f){
		if (this.size - f.getSize() >= 0){
			reduce (f.getSize());
			return true;
		} else{
			return false;
		}  
	}
	
	//returns the ID of Disk
	public int getId(){
		return this.id;
	}
	
	//add Folder in the list
	public void addInDisk (Folder f){
		this.folders.insertAtBack(f);
		
	}
	
	public int compareTo(Disk d){
		if (this.getFreeSpace() > d.getFreeSpace()){
			return 1;
		} else if (this.getFreeSpace() < d.getFreeSpace()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	// index of Disk in table of Disks
	public void setIndex (int index){
		this.index= index;
		
	}
	
	public int getIndex(){
		return this.index;
	}
	
	
}