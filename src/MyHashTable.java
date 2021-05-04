import java.util.*;

public class MyHashTable<Key, Value> {
    private static final int default_table_size = 10;

    private LinkedList<Student>[] theLists;

    public MyHashTable() {
        theLists = new LinkedList[default_table_size];

        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    public void insert(Student student) {
        LinkedList<Student> whichList = theLists[myHash(student.getStudentId())];

        if (!whichList.contains(student))
            whichList.add(student);
    }

    public void remove(Student student) {
        LinkedList<Student> whichList = theLists[myHash(student.getStudentId())];

        if (whichList.contains(student))
            whichList.remove(student);
    }


    public Student get(Integer id) {
        LinkedList<Student> whichlist;

        for (int i = 0; i < theLists.length; i++) {
            whichlist = theLists[i];
            for (int j = 0; j < whichlist.size(); j++) {
                Student ogrencibilgisi = whichlist.get(j);
                if (ogrencibilgisi.getStudentId() == (id)) {
                    return ogrencibilgisi;
                }
            }
        }
        return null;
    }

    public void printHashTable() {
        LinkedList<Student> whichList;

        for (int i = 0; i < theLists.length; i++) {
            whichList = theLists[i];

            System.out.print("|" + i + "|" + " --> ");

            for (int j = 0; j < whichList.size(); j++)
                System.out.print(whichList.get(j) + " --> ");

            System.out.println();
        }
    }

    private int myHash(Integer x) {
        return (x % theLists.length);
    }
}