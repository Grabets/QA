package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bogdan on 3/4/2017.
 */
public class RootsStorage {
    private List<double[]> listOfRoots;
    private List<Integer> listOfNullRoots;
    private List<Integer> listOfInvalidEquation;
    private List<double[]> listOfSortedRoots;

    public boolean addRoots (int num, double[] solvedRoots){
        if (solvedRoots==null){
            listOfNullRoots.add(num);
            return true;
        }
        if (solvedRoots.length==2) {
            for (int i = 0; i < solvedRoots.length; i++) {
                double[] temp = {num, solvedRoots[i]};
                listOfRoots.add(temp);
            }
        }
        else{
            double[] temp = {num, solvedRoots[0]};
            listOfRoots.add(temp);
        }
        sortRoots();
        return true;
    }

    public void sortRoots(){
        this.listOfSortedRoots = new ArrayList<>();
        if (listOfRoots.size()!=0){
            listOfSortedRoots.addAll(listOfRoots);
            int length = listOfSortedRoots.size();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length-i-1; j++) {
                    if (listOfSortedRoots.get(j)[1]>listOfSortedRoots.get(j+1)[1]){
                        double[] temp = listOfSortedRoots.get(j+1);
                        listOfSortedRoots.set(j+1,listOfSortedRoots.get(j));
                        listOfSortedRoots.set(j,temp);
                    }
                }
            }
        }
        else
            System.out.println("We couldn't sort empty massive");
    }

    public double getMaxRoot(){
        return listOfSortedRoots.get(listOfSortedRoots.size()-1)[1];
    }

    public double getMinRoot(){
        return listOfSortedRoots.get(0)[1];
    }

    public double getNumOfEquationWithMaxRoot(){
       return  listOfSortedRoots.get(listOfSortedRoots.size()-1)[0];
    }

    public double getNumOfEquationWithMinRoot(){
        return  listOfSortedRoots.get(0)[0];
    }

    public void addInvalidEquation(int num){
        listOfInvalidEquation.add(num);
    }

    public void printListOfRoots(List<double[]> list){
        System.out.print("List of Roots: ");
        System.out.print("[ ");
        for (double[] a: list) {
            System.out.print(Arrays.toString(a));
            System.out.print(" , ");
        }
        System.out.println(" ]");
    }

    public void printListOfNullRoots(List<String> list){
        System.out.print("List equation which haven't real roots (D<0): [");
        for (int i = 0; i < list.size() ; i++) {
            if (listOfNullRoots.contains(i)){
                System.out.print(list.get(i));
                System.out.print(" , ");
            }
        }
        System.out.println("]");
    }
    public void printListOfInvalidEquation(){
        System.out.print("List of invalid Equation: ");
        System.out.println(listOfInvalidEquation.toString());
    }


    public List<Integer> getListOfInvalidEquation() {
        return listOfInvalidEquation;
    }

    public List<double[]> getListOfRoots() {
        return listOfRoots;
    }

    public List<Integer> getListOfNullRoots() {
        return listOfNullRoots;
    }

    public List<double[]> getListOfSortedRoots() {
        return listOfSortedRoots;
    }

    public RootsStorage() {
        this.listOfRoots = new ArrayList<>();
        this.listOfNullRoots = new ArrayList<>();
        this.listOfInvalidEquation = new ArrayList<>();
        //this.listOfSortedRoots = new ArrayList<>();
    }
    //only for test
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(1,0);
        System.out.println(list.toString());

    }
}
