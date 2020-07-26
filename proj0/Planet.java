public class Planet{
	static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p) {
		double dx, dy;
		dx = p.xxPos - xxPos;
		dy = p.yyPos - yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	}

	public double calcForceExertedBy(Planet p) {
	        //static final double G = 6.67e-11;
		double dist = calcDistance(p);
		return mass * p.mass * G / (dist*dist);
	}
	
	public double calcForceExertedByX(Planet p) {
		double dist = calcDistance(p);
		double dx = p.xxPos - xxPos;
		//dx = (dx>0)?:-dx;
		return calcForceExertedBy(p)*dx/dist;
	}

	public double calcForceExertedByY(Planet p) {
                double dist = calcDistance(p);
		double dy = p.yyPos - yyPos;
		//dy = (dy>0)?:-dy;                                    
		return calcForceExertedBy(p)*dy/dist;
        }

	public double calcNetForceExertedByX(Planet[] p){
		double n = 0;
		for(int i=0; i<p.length; i++){
			if(xxPos == p[i].xxPos && yyPos == p[i].yyPos)
				continue;
			n += calcForceExertedByX(p[i]);
		}
		return n;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double n = 0;
		for(int i=0; i<p.length; i++){
			if(xxPos == p[i].xxPos && yyPos == p[i].yyPos)
				continue;
			n += calcForceExertedByY(p[i]);
		}
		return n;
	}

	public void update(double time, double xF, double yF){
		double ax, ay;
		ax = xF/mass;
		ay = yF/mass;
		xxVel += time*ax;
		yyVel += time*ay;
		xxPos += time*xxVel;
		yyPos += time*yyVel;
	}
}

