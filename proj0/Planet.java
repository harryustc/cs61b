public class Planet{
	private static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	//构造函数如下
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
	
	//计算本星球和p之间的距离
	public double calcDistance(Planet p) {
		double dx, dy;
		dx = p.xxPos - xxPos;
		dy = p.yyPos - yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	}

	//计算p施加给本星球的引力
	public double calcForceExertedBy(Planet p) {
	        //static final double G = 6.67e-11;
		double dist = calcDistance(p);
		return mass * p.mass * G / (dist*dist);
	}
	
	//计算p施加给本星球X方向上的引力
	public double calcForceExertedByX(Planet p) {
		double dist = calcDistance(p);
		double dx = p.xxPos - xxPos;
		//dx = (dx>0)?:-dx;
		return calcForceExertedBy(p)*dx/dist;
	}

	//计算p施加给本星球Y方向上的引力
	public double calcForceExertedByY(Planet p) {
                double dist = calcDistance(p);
		double dy = p.yyPos - yyPos;
		//dy = (dy>0)?:-dy;                                    
		return calcForceExertedBy(p)*dy/dist;
        }

	//计算多个星球施加给本星球X方向上的合力
	public double calcNetForceExertedByX(Planet[] p){
		double n = 0;
		for(int i=0; i<p.length; i++){
			if(xxPos == p[i].xxPos && yyPos == p[i].yyPos)
				continue;
			n += calcForceExertedByX(p[i]);
		}
		return n;
	}

	//计算多个星球施加给本星球Y方向上的合力
	public double calcNetForceExertedByY(Planet[] p){
		double n = 0;
		for(int i=0; i<p.length; i++){
			if(xxPos == p[i].xxPos && yyPos == p[i].yyPos)
				continue;
			n += calcForceExertedByY(p[i]);
		}
		return n;
	}

	//更新星球当前状态
	public void update(double time, double xF, double yF){
		double ax, ay;
		ax = xF/mass;
		ay = yF/mass;
		xxVel += time*ax;
		yyVel += time*ay;
		xxPos += time*xxVel;
		yyPos += time*yyVel;
	}

	//绘制星球位置
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
		//use + to complete the file name
		//no need to use method "show" and "pause"
	}
}

