public class NBody {
    public static double readRadius(String filename){
            /* Start reading in file */
            In in = new In(filename);
            int num_of_planets = in.readInt();
            double r = in.readDouble();
            return r;
    }
    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num_of_planets = in.readInt();
        double r = in.readDouble();
        Planet[] planets = new Planet[num_of_planets];
        for(int count= 0; count < num_of_planets; count ++) {
            Planet p = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            planets[count] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-Radius, Radius);
        StdDraw.clear();



        StdDraw.enableDoubleBuffering();
        for(double time = 0; time < T; time += dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int count = 0;
            for(Planet planet : planets){
                xForces[count] = planet.calcNetForceExertedByX(planets);
                yForces[count] = planet.calcNetForceExertedByY(planets);
                planet.update(dt, xForces[count], yForces[count]);
                StdDraw.picture(0, 0, "images/starfield.jpg");
                for(Planet i : planets){
                    i.draw();
                }
                StdDraw.show();
                StdDraw.pause(10);
            }
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }


}



