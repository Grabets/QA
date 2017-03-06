package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bogdan on 3/4/2017.
 * This class check and transform String lines which include quadratic, linear and invalid equation.
 * The result of the work this class is creation arrays of double save which collect in List<double[]>.
 * For example: if quadratic then [a,b,c], linear [a,b] and if invalid equation we have null array: []
 */
public class Transformer {
    private List<double[]> transformedFile;

    public void transform (List<String> stringList){

        for (int i=0; i<stringList.size();i++)
        {
            ArrayList<String> list = new ArrayList<>();
            String s, temp;
            int j;
            s= stringList.get(i);
            j = 0;
            temp="";
            //If line is quadratic equation then split to simple parts
            if (isQuadraticEquation(s)){
                while (j<=s.length()-4){
                    if (s.charAt(j)!=' ' && s.charAt(j)!='\n'){
                        temp+=s.charAt(j);
                    }
                    else {
                        list.add(temp);
                        temp="";
                    }
                    j++;
                }
                //check for availability + or -. If true then convert to double
                if (isContainsPlusOrMinus(list.get(1),list.get(3))){
                    double a,b,c;
                    a = Double.parseDouble(list.get(0).replace("x^2",""));
                    b = Double.parseDouble(list.get(1)+list.get(2).replace("x",""));
                    c = Double.parseDouble(list.get(3)+list.get(4));
                    double[] arr = {a,b,c};
                    transformedFile.add(arr);
                }
                else{
                    transformedFile.add(new double[0]);
                }
            }
            else
                if (isLinearEquation(s)){
                temp="";
                j=0;
                    //Split to simple parts if line is linear equation.
                while (j<=s.length()-4){
                    if (s.charAt(j)!=' ' && s.charAt(j)!='\n'){
                        temp+=s.charAt(j);
                    }
                    else {
                        list.add(temp);
                        temp="";
                    }
                    j++;
                }
                    //check for availability + or -. If true then convert to double
                if (isContainsPlusOrMinus(list.get(1))){
                    double a,b;
                    a = Double.parseDouble(list.get(0).replace("x",""));
                    b = Double.parseDouble(list.get(1)+list.get(2));
                    double[] arr = {a,b};
                    transformedFile.add(arr);
                }
                else
                    transformedFile.add(new double[0]);
            }
            else
                transformedFile.add(new double[0]);
        }
    }

    private boolean isContainsPlusOrMinus (String c){
        if ("-".equals(c) || "+".equals(c))
            return true;
        return false;
    }

    private boolean isContainsPlusOrMinus (String b, String c){
        if ("-".equals(b) || "+".equals(b))
            if ("-".equals(c) || "+".equals(c))
                return true;
        return false;
    }

    private boolean isQuadraticEquation(String s){
        int count =0;
        if (s.contains("x^2"))
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==' ')
                    count++;
            }
            if (count==6 && s.contains(" ") && s.contains("x ") && s.substring(s.length()-4,s.length()).equals(" = 0"))
                   return true;
        return false;
    }

    private boolean isLinearEquation(String s){
        int count =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ')
                count++;
        }
        if (count==4 && s.contains(" ") && s.contains("x ") && s.substring(s.length()-4,s.length()).equals(" = 0"))
                return true;
        return false;
    }

    public Transformer() {
        this.transformedFile = new ArrayList<>();
    }

    public List<double[]> getTransformedFile() {
        return transformedFile;
    }

    @Override
    public String toString() {
        printTransformedFile();
        return super.toString();
    }

    private void printTransformedFile() {
        for (int i = 0; i < transformedFile.size(); i++) {
            System.out.print("Sell_"+i+" ");
            System.out.println(Arrays.toString(transformedFile.get(i)));
        }
    }
}
