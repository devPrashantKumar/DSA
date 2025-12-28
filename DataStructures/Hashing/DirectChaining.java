package DataStructures.Hashing;
import java.util.LinkedList;

public class DirectChaining{
    private LinkedList<String>[] hashTable;
    private int size;

    @SuppressWarnings("unchecked")
    public DirectChaining(int size) {
        this.hashTable = new LinkedList[size];
        this.size=size;
    }

    public int hashValue(String key){
        int sum=0;
        for(int i=0;i<key.length();i++){
            sum += key.charAt(i);
        }
        return sum%size;
    }

    public void insertElement(String key){
        int hash = hashValue(key);
        if(hashTable[hash]==null){
            hashTable[hash]=new LinkedList<>();
        }
        hashTable[hash].add(key);
    }

    public boolean searchElement(String key){
        int hash = hashValue(key);
        if(hashTable[hash]!=null && hashTable[hash].contains(key)){
            return true;
        }
        return false;
    }

    public boolean deleteElement(String key){
        int hash = hashValue(key);
        boolean isElementExists = searchElement(key);
        if(isElementExists){
            return hashTable[hash].remove(key);      
        }
        return false;
    }

    public void printHashTable(){
        for(int i=0;i<size;i++){
            System.out.println("index : "+i+" key : "+hashTable[i]);
        }
    }

    public static void main(String[] args) {
        DirectChaining dc = new DirectChaining(10);
        dc.insertElement("Hello");
        dc.insertElement("World");
        dc.insertElement("abc");
        dc.insertElement("good");
        dc.printHashTable();
        System.out.println("---------------------------------------------------");
        System.out.println("element exists : "+dc.searchElement("klm"));
        System.out.println("element exists : "+dc.searchElement("World"));
        System.out.println("element deleted : "+dc.deleteElement("def"));
        System.out.println("element deleted : "+dc.deleteElement("World"));
        System.out.println("element exists : "+dc.searchElement("World"));
        System.out.println("---------------------------------------------------");
        dc.printHashTable();

    }
}