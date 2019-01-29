import com.ming.Invoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        while(true){
            // 打出提示符号
            System.out.print("ming@ming-pc-xiao ");
            System.out.print("~/ $");
            String input = "";
            // 输入
            try{
                input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            // 拼接结果
            String result = "";
            result = input + " " + "/home/ming";
            // 输出结果
            System.out.println(invoker.exec(result));
        }
    }
}
