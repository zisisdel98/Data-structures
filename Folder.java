public class Folder {
	
	private int capacity;
	private int disk_id;
	
	Folder(int capacity){
		this.capacity= capacity;
	}
	
	public int getSize(){
		return capacity;
	}
	
	// the ID of the disk that the folder is saved
	public void setSavedDisk(int num){
		this.disk_id = num;
	}
	
	public int getSavedDisk(){
		return this.disk_id;
	}
	
}