import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Main {
	public static void main(String[] args) {
       
        List<String> list = ["item"];
    
        List<String> names = new ArrayList<String>(){
            {
                for(int i=0; i<10; i++) {
                    add("A"+i);
                }
            }
        };


        Iterator it = names.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
        }
	}
}