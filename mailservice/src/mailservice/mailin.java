package mailservice;

import java.util.*;
import javax.activation.*;

public class mailin {
	public static void main(String args[]) {
	int i = Integer.parseInt(args[0]);
	String msg = args[1];
	System.out.print(i+msg);
	}
}
