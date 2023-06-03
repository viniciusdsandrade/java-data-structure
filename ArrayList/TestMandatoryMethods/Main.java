package ArrayList.TestMandatoryMethods;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>(0);

        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(0);
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(3);
        arrayList2.add(4);
        arrayList2.add(5);

        ArrayList<Integer> arrayList3 = new ArrayList(arrayList1);

        ArrayList<Integer> arrayList4 = arrayList1.clone();

        System.out.println("arrayList1.equals(arrayList2)" + arrayList1.equals(arrayList2));

        System.out.println(arrayList1.hashCode());
        System.out.println(arrayList2.hashCode());
        System.out.println(arrayList3.hashCode());
        System.out.println(arrayList4.hashCode());

        System.out.println(arrayList1);
        System.out.println(arrayList2);
        System.out.println(arrayList3);
        System.out.println(arrayList4);

    }
}
