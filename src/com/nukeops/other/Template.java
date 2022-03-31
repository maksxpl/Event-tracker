package com.nukeops.other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.nukeops.Main.initError;
import static com.nukeops.other.File.exist;

public class Template {
    /**
     * Generates:<br></br>
     * <ul>
     *  folders:
     *  <ul>
     *      <li>src/</li>
     *  </ul>
     *  files:
     *  <ul>
     *      <li>config.json</li>  <li>counter.py</li>
     *  </ul>
     * </ul>
     */
    public static void init() throws IOException{
        File file = new File("src/");
        boolean createdFolder = file.mkdir();
        if (!createdFolder&&!exist("src/")){initError("Failed to create folder: src/",4);}

        configJson();
        counterPy();
    }

    static void generate(String fileName, String string) throws IOException{
        File f = new File(fileName);
        boolean createdFile = f.createNewFile();
        if (!createdFile){initError("Failed to create file/s in: src/",3);}
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(string);
        }
    }

    static void configJson() throws IOException {
        if(!exist("src\\config.json")){
            generate("src\\config.json", """
                    {
                        "Gw2Path": "C:\\\\path",
                        "BlishPath": "C:\\\\path",
                        "InstallBlish": false,
                        "InstallArc": false
                    }
                    """);
        }
    }

    static void counterPy() throws IOException {
            if(!exist("src\\Counter.py")){
                generate("src\\Counter.py", """
                        from bisect import bisect_left
                        import datetime
                        # from datetime import datetime

                        now = datetime.datetime.now()
                        current_time = now.strftime("%H:%M:%S")
                        current_hour = int(now.strftime("%H"))
                        current_minute = int(now.strftime("%M"))
                        current_second = int(now.strftime("%S"))

                        def take_closest(myList, myNumber):
                            pos = bisect_left(myList, myNumber)
                            if pos == 0:
                                return myList[0]
                            if pos == len(myList):
                                return myList[-1]
                            before = myList[pos - 1]
                            after = myList[pos]
                            if after - myNumber < myNumber - before:
                                return after
                            else:
                                return before

                        hours = [a for a in range(0,25,2)]

                        closest = take_closest(hours,current_hour+2)

                        time_1 = datetime.timedelta(hours= current_hour , minutes=current_minute, seconds=current_second)
                        time_2 = datetime.timedelta(hours= closest, minutes=0, seconds=0)
                        diff = time_2 - time_1
                        # print(f"\\
                        # Current time: {current_time}\\n\\
                        # Closest time: {closest}\\n\\
                        # Diff: {diff}\\
                        # ")
                        print(diff, end="")
                                    """);
            }
    }
}
