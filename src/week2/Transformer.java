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
            //TODO: wrap in try-catch block
            ArrayList<String> list = new ArrayList<>();
            String s, temp;
            int j;
            s= stringList.get(i);
            j = 0;
            temp="";
            if (isQuadraticEquation(s)){
                //TODO: check if s.length() < 4
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
                double a,b,c;
                a = Double.parseDouble(list.get(0).replace("x^2",""));
                b = Double.parseDouble(list.get(1)+list.get(2).replace("x",""));
                c = Double.parseDouble(list.get(3)+list.get(4));
                double[] arr = {a,b,c};
                transformedFile.add(arr);
            }
            else
                if (isLinearEquation(s)){
                temp="";
                j=0;
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
                double a,b;
                a = Double.parseDouble(list.get(0).replace("x",""));
                b = Double.parseDouble(list.get(1)+list.get(2));
                double[] arr = {a,b};
                transformedFile.add(arr);
            }
            else
                transformedFile.add(new double[0]);
        }
    }

    //// TODO: check plus or minus availability
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

    private void setTransformedFile(List<double[]> transformedFile) {
        this.transformedFile = transformedFile;
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
