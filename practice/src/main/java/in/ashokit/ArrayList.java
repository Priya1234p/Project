package in.ashokit;

import java.util.Arrays;
import java.util.List;

public class ArrayList {
	
	public static void main(String[] args) {
		List<String> names=Arrays.asList("Ashok","Anu","Arpita","Rani","Sita");
		names.stream().filter(name->name.startsWith("A")).map(name->name.length()).forEach(name->System.out.println(name));
	}

}
