package wy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by wyzhangdongsheng1 on 15-1-13.
 */
public class JJJ {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(new File("E:\\test.txt")));
        String s = "<table style=\"margin:auto; width:95%;\">" +
                "\n\t<tr>";
        int num = 1;
        while (in.hasNext()) {
            String ss = in.nextLine();
//            System.out.println(ss);
            String[] sss = ss.split("：");
            if (sss.length == 1) {
                if (ss.contains("：")) {
                    String str1 = "<td align=\"right\">" + sss[0].trim() + "：" + "</td>";
                    String str2 = "<td>";
                    while (in.hasNext()) {
                        String line = in.nextLine();
                        if (line.contains("</select>")) {
                            str2 += "\n\t" + line + "\n\t\t</td>";
                            s += "\n\t\t" + str1 + "\n\t\t" + str2;
                            break;
                        } else if (line.contains("<select")) {
                            str2 +=  "\n\t" + line;
                        } else {
                            str2 += "\n\t\t" + line;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                String str1 = "<td align=\"right\">" + sss[0].trim() + "：" + "</td>";
                String str2 = "";
                if(sss[1].contains("combobox")){
                    str2 = "<td>" + sss[1];
                    while(in.hasNext()){
                        String line = in.nextLine();
                        str2 += "\n" + line;
                        if(line.contains("\">")){
                            break;
                        }
                    }
                    str2 += "\n\t\t</td>";
                } else
                    str2 = "<td>" + sss[1] + "</td>";
                s += "\n\t\t" + str1 + "\n\t\t" + str2;
            }
            if (num % 3 == 0)
                s += "\n\t</tr>" + "\n\t<tr>";
            else
                s += "\n\t\t<td></td>\n\t\t<td></td>";
            num++;
        }
        s += "\n\t</tr>";
        s += "\n\t<tr>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" onclick=\"searchByPD()\">查询</a></td>";
        s += "\n\t\t<td><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-undo\" onclick=\"resetByPD()\">重置</a></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t\t<td></td>";
        s += "\n\t</tr>\n</table>";
        System.out.println(s);
    }
}
