
public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

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

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r_square = dx * dx + dy * dy;
        return Math.sqrt(r_square);
    }

    public double calcForceExertedBy(Planet p){
        double G_constant = 6.67e-11;
        double distance = calcDistance(p);
        double F = G_constant * this.mass * p.mass / (distance * distance);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] all_planets){
        double force_sum = 0;
        for(Planet planet : all_planets){
            if (!planet.equals(this)){
                force_sum += calcForceExertedByX(planet);
            }
        }
        return force_sum;
    }
    public double calcNetForceExertedByY(Planet[] all_planets){
        double force_sum = 0;
        for(Planet planet : all_planets){
            if (!planet.equals(this)){
                force_sum += calcForceExertedByY(planet);
            }
        }
        return force_sum;
    }
    public void update(double dt, double fx, double fy){
        double x_acceleration = fx / mass;
        double y_acceleration = fy / mass;
        xxVel = xxVel + x_acceleration * dt;
        yyVel = yyVel + y_acceleration * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }
}
