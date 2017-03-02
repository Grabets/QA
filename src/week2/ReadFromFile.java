package week2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bogdan on 3/1/2017.
 */
public class ReadFromFile {

    private static List ReadFromFile(){
        String s;
        String fileName = "src/week2/data.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //list.forEach(System.out::println);
        return list;
    }

    private static void ConversionEquation(String s){
        String temp="";
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        if (s.contains("x^2") && s.contains(" ") && s.contains("x ") && s.substring(s.length()-4,s.length()).equals(" = 0")){
            while (i<=s.length()-4){
                if (s.charAt(i)!=' ' && s.charAt(i)!='\n'){
                    //System.out.print(s.charAt(i));
                    temp+=s.charAt(i);
                }
                else {
                    list.add(temp);
                    temp="";
                    //System.out.println();
                }
                i++;
            }
            double a,b,c;
            a = Double.parseDouble(list.get(0).replace("x^2",""));
            b = Double.parseDouble(list.get(1)+list.get(2).replace("x",""));
            c = Double.parseDouble(list.get(3)+list.get(4));
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("c: " + c);
            System.out.println(list.toString());
            System.out.println(list.size());
        }
        else
            System.out.println("Incorrect input");
    }

    private static void SolutionQE(double a, double b, double c){
        double disc = Math.pow(b,2)-4*a*c;
        System.out.println("Result:");

        if (a==0&b!=0)
        {
            System.out.println("x="+(0-c)/b);
        }          else
        if (disc > 0&&a!=0){
            System.out.println("x1= "+((0-b+Math.sqrt(disc))/(2*a)));
            System.out.println("x2= "+((0-b-Math.sqrt(disc))/(2*a)));
        }
        else
        if (disc==0&&a!=0)
            System.out.println("x1=x2= "+((0-b)/(2*a)));
        else
            System.out.println("Discriminant is negative, then there are no real roots.");
    }

    public static void main(String[] args) {
        String s = "4x^2 - 0x - 16 = 0";

        List<String> list = ReadFromFile();
        for (String t:list) {
            ConversionEquation(t);
            System.out.println("____________________________________________");
        }

    }
}
