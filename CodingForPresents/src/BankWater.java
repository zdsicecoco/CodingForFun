import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by wyzhangdongsheng1 on 2014/9/12.
 */
public class BankWater {
    public static void main(String[] args) {
        Scanner scanner = null;
        scanner = new Scanner(System.in);

        double[] in = new double[25];
        double[] out = new double[25];
        double[] left = new double[25];

        int num = -1;
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] lines = line.split(";");

            num++;
            if(!lines[1].equals("?")) in[num] = Double.valueOf(lines[1]);
            else in[num] = -1;
            if(!lines[2].equals("?")) out[num] = Double.valueOf(lines[2]);
            else out[num] = -1;
            if(!lines[3].equals("?")) left[num] = Double.valueOf(lines[3]);
            else left[num] = -1;

            if(in[num] == -1 && (out[num] != 0 && out[num] != -1)) in[num] = 0;
            if(out[num] == -1 && (in[num] != 0 && in[num] != -1)) out[num] = 0;
        }

        if(num >= 0){
            if(left[0] == -1){
                left[0] = left[1] - in[1] + out[1];
            }
        }
        for(int i = 1; i <= num; i++){
            if(in[i] == -1 || out[i] == -1)
            {
                double tmp = left[i] - left[i - 1];
                if(tmp > 0){
                    in[i] = tmp;
                    out[i] = 0;
                } else{
                    out[i] = tmp;
                    in[i] = 0;
                }
            }
            if(left[i] == -1){
                left[i] = left[i - 1] + in[i] - out[i];
            }
        }
        System.out.println("流水记录ID;收入;支出;余额");
        DecimalFormat df = new DecimalFormat("#.00");
        for(int i = 0; i <= num; i++){
            System.out.println((i + 1) + ";" + df.format(in[i])+ ";" + df.format(out[i]) + ";" + df.format(left[i]));
        }
    }
}
