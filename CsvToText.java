package Task24;
import java.io.*;
import java.util.*;
public class CsvToText{

    public static void main(String[] args)throws Exception {
        File file=new File("C:/Users/sumadeep/Desktop/employees.csv");
        BufferedReader br=new BufferedReader(new FileReader(file));

        Map<String,Double> deptMap=new HashMap<>();
        Map<String,Integer> countMap=new HashMap<>();
        br.readLine();
        String line;
        while ((line=br.readLine())!=null) {
            String [] arr=line.split(",");
            String dept=arr[1];
            Double salary= Double.parseDouble(arr[2]);

            if(deptMap.containsKey(dept)&& countMap.containsKey(dept)){
                deptMap.put(dept,deptMap.get(dept)+salary);
                countMap.put(dept,countMap.get(dept)+1);
            }
            else{
                deptMap.put(dept, salary);
                countMap.put(dept,1);
            }
            File file2=new File("C:/Users/sumadeep/Desktop/results.txt");

            BufferedWriter bfr=new BufferedWriter(new FileWriter(file2));

            for(Map.Entry<String,Double> value: deptMap.entrySet()){
                bfr.write(value.getKey()+" department average salary is "+value.getValue()/countMap.get(value.getKey())+"\n");
            }

        bfr.close();
            
        }
    br.close();
    }


}