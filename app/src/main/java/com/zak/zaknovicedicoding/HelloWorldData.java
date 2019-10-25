package com.zak.zaknovicedicoding;

import java.util.ArrayList;

public class HelloWorldData {

    private static String names [] = {
            "Pascal", // 1
            "C",      // 2
            "C++",    // 3
            "C#",     // 4
            "Java",   // 5
            "Python", // 6
            "Ruby,",   // 7
            "PHP",     // 8
            "Javascript", // 9
            "GoLang"   // 10
    };


    private static String helloWorldExamples [] =
            {
                    "writeln('Hello World');",
                    "placeholder",
                    "cout<<'Hello World'<<endl;",
                    "Console.out.println('Hello World');",
                    "System.out.println('Hello World')",
                    "println('Hello World')",
                    "placeholder",
                    "echo 'Hello World';",
                    "console.log('Hello World');",
                    "placeholder"
            };

    private static int[] helloWorldImages = {

            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred,
            R.drawable.bluefred

    };

    static ArrayList<HelloWorld> getListData() {
        ArrayList<HelloWorld> list = new ArrayList<>();
        for (int position = 0; position < names.length; position++) {
            HelloWorld hw = new HelloWorld();
            hw.setName(names[position]);
            hw.setDetail(helloWorldExamples[position]);
            hw.setPhoto(helloWorldImages[position]);
            list.add(hw);
        }
        return list;
    }

}
