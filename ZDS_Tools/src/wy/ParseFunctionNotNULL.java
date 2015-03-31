package wy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by wyzhangdongsheng1 on 15-1-14.
 */
public class ParseFunctionNotNULL {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(new File("E:\\GEEK\\IDEA\\CodingForFun\\ZDS_Tools\\src\\wy\\notnull")));
        String str = "if(";
        boolean fir = true;
        while(in.hasNext()){
            String line = in.nextLine();
            line = line.trim();
            int i1 = line.indexOf('.');
            String str1 = line.substring(0, i1);
            String str2 = line.substring(i1 + 1 , line.length());
            str1 = str1.substring(4, str1.length() - 2);
            str2 = str2.substring(0, 7);
//            System.out.println(str1 + ":" + str2);
            if(str2.charAt(0) == 't'){
                if(fir) {
                    str += "notNULLInputText('" + str1 + "')";
                    fir = false;
                    continue;
                }
                str += " && " + "notNULLInputText('" + str1 + "')";
            } else if(str2.charAt(0) == 'c'){
                if(fir){
                    str += "notNULLInputCombobox('" + str1 + "')";
                    fir = false;
                    continue;
                }
                str += " && " + "notNULLInputCombobox('" + str1 + "')";
            }
        }
        str += "){\n" + "    $('#fm').form('submit',{\n" +
                "        url: saveUrl,\n" +
                "        onSubmit: function(){\n" +
                "            return $(this).form('validate');\n" +
                "        },\n" +
                "        success: function(flag){\n" +
                "            if (flag == \"-1\"){\n" +
                "                $.messager.show({\n" +
                "                    title: '错误',\n" +
                "                    msg: \"保存失败\"\n" +
                "                });\n" +
                "            } else {\n" +
                "                $('#dlg').dialog('close');        // close the dialog\n" +
                "                $('#dg').datagrid('reload');    // reload the user data\n" +
                "            }\n" +
                "        }\n" +
                "    });\n}";
        System.out.println(str);
    }
}
