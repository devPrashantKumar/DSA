package AZStriverPlaylist.BasicHashing.Hashing;

public class LinearProbing {
    String[] hashTable;
    int usedCells;

    public LinearProbing(int size) {
        this.hashTable = new String[size];
        this.usedCells = 0;
    }

    public int hashValue(String key){
        int sum=0;
        for(int i=0;i<key.length();i++){
            sum += key.charAt(i);
        }
        return sum%hashTable.length;
    }

    public double loadFactor(){
        return usedCells*1.0/hashTable.length;
    }

    public void resizeHashTable(){
        String[] tempArray = hashTable;
        hashTable = new String[2*hashTable.length];
        usedCells=0;
        for (String element : tempArray) {
           if(element!=null && !element.equals("DELETED")) insertElement(element); 
        }
    }

    public void insertElement(String key){
        double loadFactor = loadFactor();
        if(loadFactor>=0.75){
            resizeHashTable();
        }
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i)%hashTable.length;
            if(hashTable[newIndex]==null || hashTable[newIndex].equals("DELETED") ) {
                hashTable[newIndex]=key;
                usedCells++;
                break;
            }
        }
    }

    public boolean searchElement(String key){
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i)%hashTable.length;
            if(hashTable[newIndex]==null){
                return false;
            }
            if(hashTable[newIndex].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteElement(String key){
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i)%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(key)) {
                hashTable[newIndex]="DELETED";
                usedCells--;
                return true;
            }
        }
        return false;
    }

    public void printHashTable(){
        for(int i=0;i<hashTable.length;i++){
            System.out.println("index : "+i+" key : "+hashTable[i]);
        }
    }

    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing(10);

        lp.insertElement("Hello");
        lp.insertElement("World");
        lp.insertElement("abc");
        lp.insertElement("good");
        lp.printHashTable();
        System.out.println("---------------------------------------------------");
        System.out.println("element exists : "+lp.searchElement("klm"));
        System.out.println("element exists : "+lp.searchElement("World"));
        System.out.println("element deleted : "+lp.deleteElement("def"));
        System.out.println("element deleted : "+lp.deleteElement("World"));
        System.out.println("element exists : "+lp.searchElement("World"));
        System.out.println("---------------------------------------------------");
        lp.printHashTable();
        System.out.println("---------------------------------------------------");
        lp.insertElement("Hello1");
        lp.insertElement("Hello2");
        lp.insertElement("Hello3");
        lp.insertElement("Hello4");
        lp.insertElement("Hello5");
        lp.insertElement("Hello6");
        lp.insertElement("Hello7");
        lp.insertElement("Hello8");
        lp.insertElement("Hello9");
        lp.insertElement("Hello10");
        lp.printHashTable();
        System.out.println("---------------------------------------------------");


    }
    
}
