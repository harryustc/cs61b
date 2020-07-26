public class NBody{
	public static double readRadius(String path){
		In univ = new In(path);
		int pn = univ.readInt();
		return univ.readDouble();
	}
}
