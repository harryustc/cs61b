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

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] p = readPlanets(filename);
		double rad = readRadius(filename);

		StdDraw.setScale(0-rad, rad);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");

		int len = p.length;
		for(int i=0; i<len; i++){
			p[i].draw();
		}

		StdDraw.enableDoubleBuffering(); 

		double[] xForces = new double[len];
		double[] yForces = new double[len];
		for(double i=0; i<T; i+=dt){
			for(int j=0; j<len; j++){
				xForces[j] = p[j].calcNetForceExertedByX(p);
				yForces[j] = p[j].calcNetForceExertedByY(p);
			}
			for(int j=0; j<len; j++){
				p[j].update(dt,xForces[j],yForces[j]);
			}
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int j=0; j<len; j++){
				p[j].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", len);
		StdOut.printf("%.2e\n", rad);
		for (int i=0; i<len; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", p[i].xxPos, p[i].yyPos, p[i].xxVel, p[i].yyVel, p[i].mass, p[i].imgFileName);
		}
	}
}
