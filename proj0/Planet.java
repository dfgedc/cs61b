public class Planet {
   public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final  double G = 6.67e-11;
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.mass = b.mass;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Planet p){
        double x1 = (this.xxPos - p.xxPos)*(this.xxPos-p.xxPos);
        double y1 = (this.yyPos-p.yyPos)*(this.yyPos-p.yyPos);
        return Math.sqrt(x1+y1);
    }
    public double calcForceExertedBy(Planet p){
        double F = this.mass*p.mass*G/(calcDistance(p)*calcDistance(p));
        return  F;
       // calcDistance(p)*calcDistance(p);
    }
    public double calcForceExertedByX(Planet p){
        double FX = calcForceExertedBy(p)*(p.xxPos - this.xxPos)/calcDistance(p);
        return Math.abs(FX);
    }
    public double calcForceExertedByY(Planet p){
        double FY = calcForceExertedBy(p) *(p.yyPos - this.yyPos)/calcDistance(p);
        return Math.abs(FY);
    }
    public double calcNetForceExertedByX(Planet[] p ){
        double F = 0;
        for (int i = 0; i < p.length; i++) {
            if(!this.equals(p[i])) {
                F += calcForceExertedByX(p[i]);
            }
            }
        return Math.abs(F);
    }
    public double calcNetForceExertedByY(Planet[] p){
        double F = 0;
        for (int i = 0; i < p.length; i++) {
            if (!this.equals(p[i])) {
                F += calcForceExertedByY(p[i]);
            }
        }
        return Math.abs(F);
    }

    public void update(double seconds,double xxForce,double yyForce){
            double ax = xxForce/this.mass;
            double ay = yyForce/this.mass;
            this.xxVel = this.xxVel+seconds*ax;
            this.yyVel = this.yyVel+seconds*ay;
            this.xxPos = this.xxPos+ seconds*this.xxVel;
            this.yyPos = this.yyPos+seconds*this.yyVel;
    }
    public void  draw(){
        String filename = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filename);
    }
}
