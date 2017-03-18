package week2.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 3/13/2017.
 */
public class Storage {
    private List<Equation> equationList;
    private List<Double> listOfRoots;

    public Storage() {
        equationList = new ArrayList<>();
        listOfRoots = new ArrayList<>();
    }

    public void fillEquationList(List<String> stringList){
        Parser parser = new Parser();
        int count = 0;
        for (String s:
                stringList ) {
            if (parser.parse(s)==1)
            {
                QuadraticEquation quadraticEquation = new QuadraticEquation();
                quadraticEquation.parse(s);
                quadraticEquation.setId(count);
                equationList.add(quadraticEquation);
            }
            else
            if (parser.parse(s)==0){
                LinearEquation linearEquation = new LinearEquation();
                linearEquation.parse(s);
                linearEquation.setId(count);
                equationList.add(linearEquation);
            }
            count++;
        }
    }

    public void fillListOfRoots(){
        if (equationList.size()==0)
            System.out.println("Please fill list with equations");
        else{
            for (Equation equation: equationList) {
                if (equation.getRoots()!=null)
                    listOfRoots.addAll(equation.getRoots());
            }
            sortListOfRoots();
        }
    }

    public void printMinAndMaxRoots(){
        System.out.println("Min root is: "+listOfRoots.get(0)+"; Max root is: "+listOfRoots.get(listOfRoots.size()-1));
    }

    public void printEquationWithMinMaxRoot(){
        System.out.print("Equation which include min root is: ");
        printEquationWithRoot(listOfRoots.get(0));
        System.out.print("Equation which include max root is: ");
        printEquationWithRoot(listOfRoots.get(listOfRoots.size()-1));
    }

    private void sortListOfRoots(){
        int length = listOfRoots.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (listOfRoots.get(j)>listOfRoots.get(j+1)){
                    double temp = listOfRoots.get(j+1);
                    listOfRoots.set(j+1,listOfRoots.get(j));
                    listOfRoots.set(j,temp);
                }
            }
        }
    }

    public void printListOfRoots(){
        System.out.println(listOfRoots.toString());
    }

    private void printEquationWithRoot(Double root) {
        List<Double> list;
        for (Equation e: equationList
             ) {
            list = e.getRoots();
            if (list != null)
                for (Double d: list
                     ) {
                    if (root.compareTo(d)==0)
                        System.out.println(e.getEquation());
                }
        }
    }

    public void printEquationWithNegDesc(){
        List<Double> list;
        System.out.print("Quadratic equation with D<0: [");
        for (Equation e: equationList
                ) {
            list = e.getRoots();
            if (list == null)
                System.out.print(e.getEquation()+" , ");
        }
        System.out.println("]");
    }

    public List<Equation> getEquationList() {
        return equationList;
    }

}
