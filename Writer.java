public class Writer {
	private PrintWriter pw;
	public Writer(){
		pw = new PrintWriter(System.out);
	}
	
	public void printArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void printArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void print(Object o) {
		pw.print(o.toString());
	}
	public void println(Object o) {
		pw.println(o.toString());
	}
	public void println() {
		pw.println();
	}
	public void flush() {
		pw.flush();
	}
	public void exit() {
		pw.close();
	}
}
