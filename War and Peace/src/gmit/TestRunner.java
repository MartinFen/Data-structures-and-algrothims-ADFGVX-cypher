package gmit;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class TestRunner 
{
	public TestRunner test= new TestRunner(); 
	
	private static String KeyWord="JAVA",choice;  private static int count=0;
	
	//create a hashmap that holds string keys and values
	private static Map<String, String> MyMap = new HashMap<String, String>();
	
	//create an arraylist that holds string arraylist(s)
	private static List<ArrayList<String>> List = new ArrayList<ArrayList<String>>();
	
	private static List<String> decrypt = new ArrayList<String>();
	private static List<String> Mydecrypt = new ArrayList<String>();
	//METHODS
	
	
	//MAIN Method
	public static void main(String[] args) throws Exception 
	{	
		
		System.out.print("Enter a file to encrypt (1)(WarandPeace.txt), (2)(PoblachtNaHeireann.txt), (3)(DeBelloGallico.txt): ");
		Scanner Choose = new Scanner(System.in);
		choice = Choose.nextLine();
		
		System.out.print("Enter a password: ");
		Scanner Input = new Scanner(System.in);
		KeyWord = Input.nextLine();
		Choose.close();
		Input.close();
		
		long StartTime = System.currentTimeMillis();
			
		initCipher();
		InitColumn();
		ParseandEncrypt();
		decrypt();
			
		System.out.println("Running time (MS): "+((System.currentTimeMillis()) - StartTime));	
	}

	
	private static void InitColumn() 
	{
		for (int i = 0; i < KeyWord.length(); i++) //intiate a loop to run x times based on the size of the user input  
		{
			List<String> KeyList = new ArrayList<String>();//declare an array list to of type string 
			
			KeyList.add(String.valueOf(KeyWord.charAt(i)).toUpperCase());//populate the arraylist
			
			List.add((ArrayList<String>) KeyList);
		}
		
	}
	
	public static void ParseandEncrypt() throws Exception
	{
		BufferedReader BR = new BufferedReader(new InputStreamReader(
				new FileInputStream(choice),Charset.forName("UTF-8")));
	
		
		int line;
		while((line = BR.read()) != -1)
		{  
			char c = (char) line;		
			
			List.get(count).add(MyMap.get(Character.toString(c).toUpperCase()));
			
			decrypt.add(MyMap.get(Character.toString(c).toUpperCase()));
			
			count++;
			if(count>=KeyWord.length())
			{
				count=0;	
			}
		}
		BR.close();
		
		PrintWriter PW = new PrintWriter("encrypt.txt");
		PW.print(List.toString());
		PW.close();
	}
	
	
	private static void decrypt() throws Exception 
	{	
		for(int i=0;i<decrypt.size();i++)
		{
			Mydecrypt.add(MyMap.get(decrypt.get(i)));
		}

		PrintWriter PW2 = new PrintWriter("decrypt.txt");
		PW2.print(Mydecrypt.toString());
		PW2.close();	
	}
	//Big O for the Hash Map is O(1) constant time
	public static void initCipher() throws Exception
	{
		MyMap.put("AA", "P");//AA - P
		MyMap.put("AD", "H");//AD - H
		MyMap.put("AF", "0");//
		MyMap.put("AG", "Q");//
		MyMap.put("AV", "G");//
		MyMap.put("AX", "6");//
		MyMap.put("DA", "4");//
		MyMap.put("DD", "M");//
		MyMap.put("DF", "E");//
		MyMap.put("DG", "A");//
		MyMap.put("DV", "1");//
		MyMap.put("DX", "Y");//
		MyMap.put("FA", "L");//
		MyMap.put("FD", "2");//
		MyMap.put("FF", "N");//
		MyMap.put("FG", "O");//
		MyMap.put("FV", "F");//
		MyMap.put("FX", "D");//
		MyMap.put("GA", "X");//
		MyMap.put("GD", "K");//
		MyMap.put("GF", "R");//
		MyMap.put("GG", "3");//
		MyMap.put("GV", "C");//
		MyMap.put("GX", "V");//
		MyMap.put("VA", "S");//
		MyMap.put("VD", "5");//
		MyMap.put("VF", "Z");//
		MyMap.put("VG", "W");//
		MyMap.put("VV", "7");//
		MyMap.put("VX", "B");//
		MyMap.put("XA", "J");//
		MyMap.put("XD", "9");//
		MyMap.put("XF", "U");//
		MyMap.put("XG", "T");//
		MyMap.put("XV", "I");//
		MyMap.put("XX", "8");//		
		
		MyMap.put("P", "AA");//
		MyMap.put("H", "AD");//
		MyMap.put("0", "AF");//
		MyMap.put("Q", "AG");//
		MyMap.put("G", "AV");//
		MyMap.put("6", "AX");//
		MyMap.put("4", "DA");//
		MyMap.put("M", "DD");//
		MyMap.put("E", "DF");//
		MyMap.put("A", "DG");//
		MyMap.put("1", "DV");//
		MyMap.put("Y", "DX");//
		MyMap.put("L", "FA");//
		MyMap.put("2", "FD");//
		MyMap.put("N", "FF");//
		MyMap.put("O", "FG");//
		MyMap.put("F", "FV");//
		MyMap.put("D", "FX");//
		MyMap.put("X", "GA");//
		MyMap.put("K", "GD");//
		MyMap.put("R", "GF");//
		MyMap.put("3", "GG");//
		MyMap.put("C", "GV");//
		MyMap.put("V", "GX");//
		MyMap.put("S", "VA");//
		MyMap.put("5", "VD");//
		MyMap.put("Z", "VF");//
		MyMap.put("W", "VG");//
		MyMap.put("7", "VV");//
		MyMap.put("B", "VX");//
		MyMap.put("J", "XA");//
		MyMap.put("9", "XD");//
		MyMap.put("U", "XF");//
		MyMap.put("T", "XG");//
		MyMap.put("I", "XV");//
		MyMap.put("8", "XX");//	
		MyMap.put("AH", ".");//
		MyMap.put("DH", "!");//
		MyMap.put("FH", "?");//
		MyMap.put("GH", " ");//
		MyMap.put("VH", "'");//
		MyMap.put("XH", ",");//
		MyMap.put(".", "AH");//
		MyMap.put("!", "DH");//
		MyMap.put("?", "FH");//
		MyMap.put(" ", "GH");//
		MyMap.put("'", "VH");//
		MyMap.put(",", "XH");//		
		MyMap.put("AP", "]");//
		MyMap.put("DP", "[");//
		MyMap.put("FP", "~");//
		MyMap.put("GP", "&");//
		MyMap.put("VP", ":");//
		MyMap.put("XP", ";");//
		MyMap.put("AP", "-");//"
		MyMap.put("DP", "");//
		MyMap.put("FP", "*");//
		MyMap.put("GP", "^");//
		MyMap.put("VP", "\"");//
		MyMap.put(null, " ");//
		
	}
}

//StringBuilder sb = new StringBuilder();
		//for (String s : Mydecrypt)
		//{
		    //sb.append(s);
		    //sb.append("\t");
		//}

/*BufferedReader BR = new BufferedReader(new InputStreamReader(
new FileInputStream("encrypt.txt"),Charset.forName("UTF-8")));

int line;
while((line = BR.read()) != -1)
{  
char c = (char) line;			

decrypt.add(MyMap.get(Character.toString(c).toUpperCase()));		
}
for(int i=0;i<decrypt.size();i++)
{
Mydecrypt.add(MyMap.get(decrypt.get(i)));
}

BR.close();


PrintWriter PW = new PrintWriter("decrypt.txt");
PW.print(Mydecrypt.toString());
PW.close();*/