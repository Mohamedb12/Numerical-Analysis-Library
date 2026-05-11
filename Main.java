import core.RootFinder;
import core.EquationFunction;
import core.dEquationFunction;
import core.Integrator;
import core.Interpolator;

import methods.bracketing.BisectionMethod;
import methods.bracketing.FalsePositionMethod;
import methods.iterative.FixedPointMethod;
import methods.iterative.NewtonRaphsonMethod;
import methods.integration.TrapezoidalMethod;
import methods.integration.SimpsonOneThirdMethod;
import methods.integration.SimpsonThreeEighthsMethod;
import methods.interpolation.LagrangeMethod;

public class Main {
    public static void main(String[] args) {
        
        double[] x = {0, 1, 2, 3};
        double[] y = {1, 2, 1, 10};
        
        
        double target = 1.5;
        
        Interpolator solver = new LagrangeMethod(x, y);
        
        System.out.println("Interpolated Y at X=" + target + " is: " + solver.interpolate(target));
    }
}
