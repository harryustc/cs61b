public class NBody{
	public static double readRadius(String path){
		In univ = new In(path);
		int pn = univ.readInt();
		return univ.readDouble();
	}

	public static Planet[] readPlanets(String path){
		In univ = new In(path);
		int n = univ.readInt();
		Planet [] p = new Planet[n];
		double rad = univ.readDouble();;
		for(int i=0; i<n; i++)
			p[i] = new Planet(univ.readDouble(), univ.readDouble(), univ.readDouble(), univ.readDouble(), univ.readDouble(), univ.readString());
			/*p[i].xxPos = univ.readDouble();
			p[i].yyPos = univ.readDouble();
			p[i].xxVel = univ.readDouble();
			p[i].yyVel = univ.readDouble();
			p[i].mass = univ.readDouble();
			p[i].imgFileName = univ.readString();*/
		return p;
	}
}
