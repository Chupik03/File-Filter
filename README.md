# Description
The program is a utility for filtering and sorting data from multiple input files containing mixed integers, real numbers, and strings.  
FileFilter.jar is located at the following path: ...\out\artifacts\FileFilter_jar
  
The application accepts the following options:  
-o: File saving path    
-p: Prefix of output file names  
-a: Add to file (overwrites by default)  
-s: Brief statistics (Number of elements)  
-f: Full statistics (The number of elements, minimum and maximum elements, average value for integers and floats. The number of elements, the length of the shortest string, and the length of the longest string)  

Example of program launch:  
java -jar util.jar -s -a -p sample- in1.txt in2.txt

# SDK
- Java version "23.0.1"
- Maven 4.0.0
- <dependencies>
        <!-- https://mvnrepository.com/artifact/commons-cli/commons-cli -->
        <dependency>
            <groupId>commons-cli</groupId>
            <artifactId>commons-cli</artifactId>
            <version>1.4</version>
        </dependency>
    </dependencies>
