public class MyArrayList<AnyType> {
    private static final int default_capacity = 10;

    private AnyType[] theItems;
    private int theSize;

    public MyArrayList() {
        clear();
    }

    public 	AnyType get(int index) {
        if (index < 0 || index >= theSize)
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + theSize);

        return theItems[index];
    }

    public AnyType set(int index, AnyType newVal) {
        if (index < 0 || index >= theSize)
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + theSize);

        AnyType old = theItems[index];
        theItems[index] = newVal;

        return old;
    }

    public boolean add(AnyType x) {
        add(theSize, x);
        return true;
    }

    public void add(int index, AnyType x) {
        if (index < 0 || index > theSize)
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + theSize);

        if (theItems.length == theSize)
            ensureCapacity(theSize * 2);

        for (int i = theSize; i > index; i--)
            theItems[i] = theItems[i - 1];

        theItems[index] = x;

        theSize++;
    }

    public AnyType remove(int index) {
        if (index < 0 || index >= theSize)
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + theSize);

        AnyType removedItem = theItems[index];

        for (int i = index; i < theSize - 1; i++)
            theItems[i] = theItems[i + 1];

        theSize--;

        return removedItem;
    }

    public void remove(AnyType x) {
        int index = 0;
        for (int i = 0; i < theSize; i++) {
            if (theItems[i].equals(x))
                index = i;
        }
        for (int i = index; i < theSize - 1; i++)
            theItems[i] = theItems[i + 1];

        theSize--;

    }


    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void clear() {
        theSize = 0;
        theItems = (AnyType[]) new Object[default_capacity];
    }

    @Override
    public String toString() {
        String rStr = "[ ";

        for (int i = 0; i < theSize; i++)
            rStr = rStr + theItems[i] + " ";

        rStr = rStr + "]";

        return rStr;
    }

    private void ensureCapacity(int newCapacity) {
        AnyType[] old = theItems;

        theItems = (AnyType[]) new Object[newCapacity];

        for (int i = 0; i < theSize; i++)
            theItems[i] = old[i];
    }
}