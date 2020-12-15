public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final  double G = 6.67e-11;
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
        return FX;
    }
    public double calcForceExertedByY(Planet p){
        double FY = calcForceExertedBy(p) *(p.yyPos - this.yyPos)/calcDistance(p);
        return FY;
    }
    public double calcNetForceExertedByX(Planet[] ps) {
        double xForce = 0;
        for(Planet p : ps) {
            if (!this.equals(p)) {
                xForce += calcForceExertedByX(p);
            }
        }

        return xForce;
    }

    /**
     *  Calculate the net Y force exerted by all planets in a array.
     *  @param planet[] a Planets array
     *  @return a double describing the net Y force exerted by other Planets
     */
    public double calcNetForceExertedByY(Planet[] ps) {
        double yForce = 0;
        for(Planet p : ps) {
            if (!this.equals(p)) {
                yForce += calcForceExertedByY(p);
            }
        }

        return yForce;
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
