import java.sql.SQLOutput;
import java.util.*;


public class Main {


    public static void main(String[] args) {
        //  Implementations of structures.
        MyArrayList<Student> myList = new MyArrayList<>();
        HashSet<String> names = new HashSet<>();
        // LinkedHashMap<Integer, Student> myHashMap = new LinkedHashMap<>();
        MyHashTable<Integer, Student> myHashTable = new MyHashTable<>();
        BinarySearchTree<Student> myBinarySearchTree = new BinarySearchTree<>();


        System.out.println("\n" +
                "▒█▀▀▄ ░█▀▀█ ▀▀█▀▀ ░█▀▀█\n" +
                "▒█░▒█ ▒█▄▄█ ░▒█░░ ▒█▄▄█\n" +
                "▒█▄▄▀ ▒█░▒█ ░▒█░░ ▒█░▒█");
        System.out.println("\n" +
                "▒█▀▀▀█ ▀▀█▀▀ ▒█▀▀█ ▒█░▒█ ▒█▀▀█ ▀▀█▀▀ ▒█░▒█ ▒█▀▀█ ▒█▀▀▀ ▒█▀▀▀█\n" +
                "░▀▀▀▄▄ ░▒█░░ ▒█▄▄▀ ▒█░▒█ ▒█░░░ ░▒█░░ ▒█░▒█ ▒█▄▄▀ ▒█▀▀▀ ░▀▀▀▄▄\n" +
                "▒█▄▄▄█ ░▒█░░ ▒█░▒█ ░▀▄▄▀ ▒█▄▄█ ░▒█░░ ░▀▄▄▀ ▒█░▒█ ▒█▄▄▄ ▒█▄▄▄█ ");
        while (true) {
            System.out.println("**********************************");
            System.out.println("0.  Exit \n" +
                    "1.  Add student \n" +
                    "2.  Delete student \n" +
                    "3.  Find student \n" +
                    "4.  List all student \n" +
                    "5.  List distinct names \n" +
                    "6.  List name counts \n" +
                    "7.  About");
            System.out.println("**********************************");
            System.out.print("Enter your selection: ");

            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();

            switch (value) {
                case "0":
                    // If user want to exit, it ask "are you sure? " then if user input yes in lower case or upper case. The program close itself.
                    System.out.println("are you sure to exit? Y/N");
                    String input = scanner.next();
                    if (input.toUpperCase().equals("Y")) {
                        System.out.println("the program is closing!");
                        System.exit(0);
                    } else if (input.toUpperCase().equals("N")) {
                        continue;
                    } else
                        // if input is different from y/Y or n/N returns that message.
                        System.out.println("UNEXPECTED INPUT");

                    break;
                case "1":
                    //Asks for users inputs  add student in structures.
                    System.out.print("Enter student name: ");
                    String answerName = scanner.nextLine();
                    System.out.print("Enter student surname: ");
                    String answerSurname = scanner.nextLine();
                    System.out.print("Enter student id: ");
                    int answerId = scanner.nextInt();
                    Student ogr1 = new Student(answerName, answerSurname, answerId);
                    //arraylist add
                    myList.add(ogr1);
                    //hash add

                    myHashTable.insert(ogr1);

                    // bst add
                    myBinarySearchTree.insertRecursively(ogr1);


                    System.out.println("**********\n" +
                            "STUDENT HAS BEEN ADDED SUCCESSFULLY.");


                    break;
                case "2":
                    // if arraylists size is 0 it returns empty message.
                    if (myList.size() == 0) {
                        System.out.println("THERE IS NO STUDENT IN THE STRUCTURES. PLEASE ADD A STUDENT.");
                        break;
                    }
                    // Asks for id for remove a student. Then remove the student in all structures.
                    System.out.print("Enter student id, that you want to remove: ");
                    int removeId = scanner.nextInt();

                    // To remove student in arraylist
                    for (int i = 0; i < myList.size(); i++) {
                        if (removeId == myList.get(i).getStudentId()) {
                            myList.remove(i);
                        }
                    }
                    // To remove student in hash
                    Student ogrenciSil = myHashTable.get(removeId);
                    if (ogrenciSil == null) {
                        System.out.println("This student isn't in the structure");
                        break;
                    }
                    myHashTable.remove(ogrenciSil);


                    /*for (int key : myHashMap.keySet()) {
                        if (removeId == key) {
                            myHashMap.remove(key);
                            break;
                        }
                    }*/
                    // To remove student from bst.
                    myBinarySearchTree.deleteRec(removeId);

                    System.out.println("Student has been removed successfully");
                    break;
                case "3":
                    // checks the arraylists size if it's 0 returns empty message.
                    if (myList.size() == 0) {
                        System.out.println("The structures are empty!");
                        break;
                    }
                    // asks for an id and tries to find.
                    System.out.print("Please enter a student id, that you want to find: ");
                    int findById = scanner.nextInt();

                    for (int i = 0; i < myList.size(); i++) {
                        if (findById == myList.get(i).getStudentId()) {
                            System.out.println("STUDENT, THAT FOUND BY HIS/HER ID: ");
                            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            System.out.println("[" + myList.get(i).getName().toUpperCase() + " " + myList.get(i).getSurname().toUpperCase() + " " + myList.get(i).getStudentId() + "]");
                            System.out.println("LIST: " + (i + 1) + " HOP");

                        }

                    }

                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    myBinarySearchTree.findNode(findById);
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                    Student ogrencibul = myHashTable.get(findById);
                    if (ogrencibul == null) {
                        System.out.println("THIS STUDENT CANNOT BE FOUND");
                        break;
                    }
                    System.out.println(ogrencibul.toString());
                    System.out.println("HASH: ");

                    break;
                case "4":

                    // checks the size of arraylist if it's 0 returns "THE STRUCTURE IS EMPTY!!"
                    if (myList.size() == 0) {
                        System.out.println("THE STRUCTURE IS EMPTY!!");

                        break;
                    }
                    System.out.println("**********************************");
                    System.out.println("Please select a data type to list names\n"
                            + "1. List\n"
                            + "2. Hash\n"
                            + "3. Tree");
                    System.out.println("**********************************");
                    System.out.print("Please choose an option: ");
                    String option = scanner.nextLine();
                    switch (option) {
                        case "1":
                            //for loop for print arraylist
                            System.out.println(myList.toString());
                            /*for (int i = 0; i < myList.size(); i++) {
                                System.out.println("[" + myList.get(i).getStudentId() + " " + myList.get(i).getName().toUpperCase() + " " + myList.get(i).getSurname().toUpperCase() + "]");

                            }*/


                            break;
                        case "2":
                            //print hashmap
                            myHashTable.printHashTable();
                            /*System.out.println( myHashMap.toString()); // {key=[name surname id ], } is the print format
                            // foreach loop for print hashmap
                            /*for (int key : myHashMap.keySet()) {
                                System.out.println("Student information: " + "[" + key + " " + myHashMap.get(key).getName().toUpperCase() + " " + myHashMap.get(key).getSurname().toUpperCase() + "]");

                            }*/
                            break;
                        case "3":
                            //Asks for print type in binary search tree.
                            System.out.println("Select print type\n" +
                                    "1. INORDER: \n" +
                                    "2. PREORDER: \n" +
                                    "3. POSTORDER: ");
                            System.out.print("Please choose an option: ");
                            String type = scanner.nextLine();

                            switch (type) {
                                case "1":
                                    System.out.println("INORDER TRAVERSAL:");
                                    myBinarySearchTree.printInorder();
                                    System.out.println();
                                    break;

                                case "2":
                                    System.out.println("PREORDER TRAVERSAL:");
                                    myBinarySearchTree.printPreorder();
                                    System.out.println();
                                    break;
                                case "3":
                                    System.out.println("POSTORDER TRAVERSAL:");
                                    myBinarySearchTree.printPostorder();
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("UNEXPECTED INPUT");
                            }
                            break;
                        default:
                            System.out.println("UNEXPECTED INPUT");
                    }

                    break;
                case "5":
                    if (myList.size() == 0) {
                        System.out.println("THE STRUCTURE IS EMPTY!!");
                    }
                    // adds distinct names in arraylist to hashset. Then print all names in hashset.
                    for (int i = 0; i < myList.size(); i++) {
                        names.add(myList.get(i).getName().toUpperCase());

                    }
                    for (String item : names)
                        System.out.println(item);


                    break;
                case "6":
                    // Create a treemap object and counts the all names in arraylist then print all names and their frequencies.
                    if (myList.size() == 0) {
                        System.out.println("THE STRUCTURE IS EMPTY!!");
                    }
                    TreeMap<String, Integer> nameCount = new TreeMap<>();
                    for (int i = 0; i < myList.size(); i++) {
                        String counts = myList.get(i).getName().toUpperCase();

                        if (nameCount.containsKey(counts)) {
                            nameCount.replace(counts, nameCount.get(counts) + 1);
                        } else {
                            nameCount.put(counts, 1);
                        }
                    }
                    for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }


                    break;
                case "7":
                    System.out.println("\uD83C\uDD77\uD83C\uDD70\uD83C\uDD82\uD83C\uDD70\uD83C\uDD7D \uD83C\uDD70\uD83C\uDD7B\uD83C\uDD70\uD83C\uDD88");
                    System.out.println("200315007 " +
                            "\nHASAN ALAY");

                    break;

                default:
                    System.out.println("UNEXPECTED INPUT");
            }

        }

    }

}


