package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public void processElements(List<? extends BexA> elements) {
        for (A a : elements) {      // A is used instead of BexA
            a.getValue();
        }

        // https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
        // https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
//        elements.add(new A());
//        elements.add(new BexA());
//        elements.add(new CexBexA());
//        elements.add(new DexBexA());
    }

    // Another approach for above, but it is only useful for definitions not usage
    public <T extends BexA> void processElementsType(List<T> elements) {
        for (A a : elements) {      // A is used instead of BexA
            a.getValue();
        }

        // Below code gives error here also
//        elements.add(new A());
//        elements.add(new BexA());
//        elements.add(new CexBexA());
//        elements.add(new DexBexA());
    }

    public void insertElements(List<? super BexA> list) {
//        list.add(new A());          // This fails as list only accepts BexA and its subclass
        list.add(new BexA());
        list.add(new CexBexA());
        list.add(new DexBexA());
//        list.add(new Object());   // This also fails

        // https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
        // https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
//        for (A a : list) {    // A a give error due to same reason as new A() above
//            a.getValue();
//        }

        Object obj = list.get(0);       // Only valid possibility
    }

    // Invalid syntax
//    public <T super BexA> void insertElementsType(List<T> list) {}

    public static void main(String[] args) {

        GenericsDemo gd = new GenericsDemo();

        List<A> listA = new ArrayList<>();
//        gd.processElements(listA);                 //ERROR
//        gd.processElementsType(listA);             //ERROR
//        List<? extends BexA> listBexAA = listA;    //ERROR as it is another version of above line


        List<BexA> listB = new ArrayList<>();
        gd.processElements(listB);
        gd.processElementsType(listB);
        List<? extends BexA> listBexAB = listB;

        List<CexBexA> listC = new ArrayList<>();
        gd.processElements(listC);
        List<? extends BexA> listBexAC = listC;

        List<DexBexA> listD = new ArrayList<>();
        gd.processElements(listD);
        List<? extends BexA> listBexAD = listD;

        ////////////////////////////////////////////////////
        List<? extends A> exA = new ArrayList<>();
//        listA.add(exA);             // ERROR but below is allowed!
        listA.addAll(exA);
//
//        A a = new A();
//        BexA bexA = a;
//        bexA.getValue();


        ////////////////////////////////////////////////////
        gd.insertElements(listA);
        List<? super BexA> listSuBexAA = listA;

        gd.insertElements(listA);
        List<? super BexA> listSuBexAB = listB;

        List<Object> listObject = new ArrayList<>();
        gd.insertElements(listObject);
        List<? super BexA> listSuBexAO = listObject;

//        gd.insertElements(listC);                   // ERROR
//        List<? super BexA> listSuBexAC = listC;     // ERROR
    }

}

class A {
    public void getValue() {
        System.out.println("In class A");
    }
}

class BexA extends A {
    public void getValue() {
        System.out.println("In class BexA");
    }
}

class CexBexA extends BexA {
    public void getValue() {
        System.out.println("In class CexBexA");
    }
}

class DexBexA extends BexA {
    public void getValue() {
        System.out.println("In class DexBexA");
    }
}