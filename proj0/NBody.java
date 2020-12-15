
public class NBody {
    public static double readRadius(String word) {
        In in = new In("./data/planets.txt");
        double firstItemInFile = in.readDouble();
        double radius = in.readDouble();
        return radius;
        //  return 1.0;
    }

    public static Planet[] readPlanets(String word) {
        //   In in = new In("./data/planets.txt");
        In in = new In(word);

        int number = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[number];
        for (int i = 0; i < planets.length; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String location = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, location);
        }

        //   planets[0] =Earth;
     /*

        double mars1 = in.readDouble();
        double mars2 = in.readDouble();
        double mars3 = in.readDouble();
        double mars4 = in.readDouble();
        double mars5 = in.readDouble();
        String mars6 = in.readString();
        Planet Mars = new Planet(mars1,mars2,mars3,mars4,mars5,mars6);
        planets[1] = Mars;
        double mercury1 = in.readDouble();
        double mercury2 = in.readDouble();
        double mercury3 = in.readDouble();
        double mercury4 = in.readDouble();
        double mercury5 = in.readDouble();
        String mercury6 = in.readString();
        Planet Mercury = new Planet(mercury1,mercury2,mercury3,mercury4,mercury5,mercury6);
        planets[2] = Mercury;
        double sun1 = in.readDouble();
        double sun2 = in.readDouble();
        double sun3 = in.readDouble();
        double sun4 = in.readDouble();
        double sun5 = in.readDouble();
        String sun6 = in.readString();
        Planet Sun = new Planet(sun1,sun2,sun3,sun4,sun5,sun6);
        planets[3] = Sun;
        double venus1 = in.readDouble();
        double venus2 = in.readDouble();
        double venus3 = in.readDouble();
        double venus4 = in.readDouble();
        double venus5 = in.readDouble();
        String venus6 = in.readString();
        Planet Venus= new Planet(venus1,venus2,venus3,venus4,venus5,venus6);
        planets[4] = Venus;
*/
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.pause(2000);
        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        StdDraw.enableDoubleBuffering();
        double time = 0;
         while (time<T) {
             for (int i = 0; i < planets.length; i++) {
                 xForces[i] = planets[i].calcNetForceExertedByX(planets);
                 yForces[i] = planets[i].calcNetForceExertedByY(planets);
             }

             for (int i = 0; i < planets.length; i++) {
                 planets[i].update(dt, xForces[i], yForces[i]);
             }
             StdDraw.picture(0, 0, "images/starfield.jpg");
             for (Planet p : planets) {
                 p.draw();
             }
             StdDraw.show();
             StdDraw.pause(10);
             time += dt;
         }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    /*
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (int i = 0; i <planets.length ; i++) {
            planets[i].draw();
        }
        double[] xForce = new double[planets.length];
        double[] yForce = new double[planets.length];
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time<T){
            for (int i = 0; i < planets.length; i++) {
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt,xForce[i],yForce[i] );
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time +=dt;
        }
     */
        /*
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String file = args[2];
        double radius = readRadius(file);
        Planet[] planets = readPlanets(file);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.pause(2000);
        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        while (t < T) {
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

         */

    }
}



