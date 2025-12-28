package DataStructures.Hashing;

public class QuadraticProbing {
    String[] hashTable;
    int usedCells;

    public QuadraticProbing(int size) {
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

    public void printHashTable(){
        for(int i=0;i<hashTable.length;i++){
            System.out.println("index : "+i+" key : "+hashTable[i]);
        }
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
        if(loadFactor >= 0.75){
            resizeHashTable();
        }
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i*i)%hashTable.length;
            if(hashTable[newIndex]==null || hashTable[newIndex].equals("DELETED")){
                hashTable[newIndex]=key;
                usedCells++;
                break;
            }
        }
    }

    public boolean searchElement(String key){
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i*i)%hashTable.length;
            if(hashTable[newIndex]==null){
                return false;
            }
            if(hashTable[newIndex].equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean deleteElement(String key){
        int hash = hashValue(key);
        for(int i=0;i<hashTable.length;i++){
            int newIndex = (hash+i*i)%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(key)){
                hashTable[newIndex]="DELETED";
                usedCells--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        QuadraticProbing qp = new QuadraticProbing(10);

        qp.insertElement("Hello");
        qp.insertElement("World");
        qp.insertElement("abc");
        qp.insertElement("good");
        qp.printHashTable();
        System.out.println("---------------------------------------------------");
        System.out.println("element exists : "+qp.searchElement("klm"));
        System.out.println("element exists : "+qp.searchElement("World"));
        System.out.println("element deleted : "+qp.deleteElement("def"));
        System.out.println("element deleted : "+qp.deleteElement("World"));
        System.out.println("element exists : "+qp.searchElement("World"));
        System.out.println("---------------------------------------------------");
        qp.printHashTable();
        System.out.println("---------------------------------------------------");
        qp.insertElement("Hello1");
        qp.insertElement("Hello2");
        qp.insertElement("Hello3");
        qp.insertElement("Hello4");
        qp.insertElement("Hello5");
        qp.insertElement("Hello6");
        qp.insertElement("Hello7");
        qp.insertElement("Hello8");
        qp.insertElement("Hello9");
        qp.insertElement("Hello10");
        qp.printHashTable();
        System.out.println("---------------------------------------------------");


    }
}
