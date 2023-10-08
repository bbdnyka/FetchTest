import java.io.File;
import java.util.*;


public class MainCHanges {

    //method for printing data from text file
    public static void  printRecord(ArrayList<String> newID, ArrayList<String> newlistId,ArrayList<String> newNameId) {

        //prints the sorted data from file
        //System.out.println("This is ID: " + newID); //ID not required for test. Can uncomment if needed
        System.out.println("This is the sorted listId: " + newlistId);
        System.out.println("This is the sorted names: " + newNameId);

    }

    public static void main(String[] args ) {

        //holds data from files
        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> listid = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<String>();

        //change filepath  to location on pc.
        String filepath="/Users/denykabrown/Desktop/Projects/Java/FetchTest/src/amazonaws.txt";

        //for reading file.
        File file = new File(filepath);
        String[] split = {};//variable for splitting strings
        try {//for catching errors
            Scanner sc = new Scanner(file);//for scanning files
            sc.nextLine();//skips first line
            while(sc.hasNext()){//makes sure scanner scans through file
                String st = sc.nextLine().trim();//removes spaces
                if(!st.isEmpty()) {//checks if file is empty

                    split = st.split(",");//splits the strings

                    //adds file data to arraylists.
                    //split[0]=ID split[1]=listid split[2]=name
                    id.add(split[0]);
                    listid.add(split[1]);
                    name.add(split[2]);
                }
                else{
                    return;//returns in file is empty
                }
                //sorts data from file
                Collections.sort(id);
                Collections.sort(listid);
                Collections.sort(name);
                //printRecord(ID,listId,name);//for test printing
            }
            sc.close();//closes scanner
        }
        catch (Exception e){
            System.out.println("Error in main method");//print error if file empty or if error within main method
        }
        printRecord(id,listid,name);//print files in this method
    }
}
