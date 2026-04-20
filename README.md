# Numerical Analysis Library 🧮

A simple, object-oriented Java library designed to solve complex mathematical problems through code. This library bridges the gap between theoretical math and practical software development using Clean Code principles and a robust architecture.

## Description
In modern engineering and science, mathematical equations are often too complex to solve accurately by hand. This library provides a programmatic way to reach precise solutions using Numerical Analysis. It is built to be reusable, modular, and easy to integrate into any Java project.

---

## 🚀 How to Use (Detailed Examples)

Below are the implementation examples for every method included in the library.

### 1. Root Finding Methods (Solving f(x) = 0)

#### A. Bisection Method
```java
// Define the equation: f(x) = x^2 - 4
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return (x * x) - 4;
    }
};

// Parameters: lower bound (0), upper bound (3), tolerance (0.001)
RootFinder solver = new BisectionMethod(0, 3, 0.001);
System.out.println("Root using Bisection = " + solver.solve(f));
```

#### B. False Position Method
```java
// Define the equation: f(x) = x^2 - 4
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return (x * x) - 4;
    }
};

// Parameters: lower bound (0), upper bound (3), tolerance (0.001)
RootFinder solver = new FalsePositionMethod(0, 3, 0.001);
System.out.println("Root using False Position = " + solver.solve(f));
```

#### C. Fixed Point Method
```java
// Requires rewriting f(x)=0 into x=g(x). For x^2 - 4 = 0, g(x) = 4/x
EquationFunction g = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return 4.0 / x;
    }
};

// Parameters: initial guess (1.5), tolerance (0.001)
RootFinder solver = new FixedPointMethod(1.5, 0.001);
System.out.println("Root using Fixed Point = " + solver.solve(g));
```

#### D. Newton-Raphson Method
```java
// Define the equation: f(x) = x^2 - 4
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return (x * x) - 4;
    }
};

// Requires the derivative: f'(x) = 2x
dEquationFunction df = new dEquationFunction() {
    @Override
    public double evaluate(double x) {
        return 2 * x;
    }
};

// Parameters: initial guess (1.0), tolerance (0.0001), derivative function
RootFinder solver = new NewtonRaphsonMethod(1.0, 0.0001, df);
System.out.println("Root using Newton-Raphson = " + solver.solve(f));
```

---

### 2. Numerical Integration Methods (Finding Area)

#### A. Trapezoidal Rule
```java
// Define the equation: f(x) = x^2
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return x * x;
    }
};

// Parameters: start (0), end (2), segment_width (0.2)
Integrator solver = new TrapezoidalMethod(0, 2, 0.2);
System.out.println("Area using Trapezoidal = " + solver.integrate(f));
```

#### B. Simpson's 1/3 Rule
```java
// Define the equation: f(x) = x^2
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return x * x;
    }
};

// Parameters: start (0), end (2), segment_width (0.2)
Integrator solver = new SimpsonOneThirdMethod(0, 2, 0.2);
System.out.println("Area using Simpson 1/3 = " + solver.integrate(f));
```

#### C. Simpson's 3/8 Rule
```java
// Define the equation: f(x) = x^2
EquationFunction f = new EquationFunction() {
    @Override
    public double evaluate(double x) {
        return x * x;
    }
};

// Parameters: start (0), end (2), segment_number (12)
Integrator solver = new SimpsonThreeEighthsMethod(0, 2, 12);
System.out.println("Area using Simpson 3/8 = " + solver.integrate(f));
```

---

## 📂 Project Structure
```text
Numerical-Analysis-Library/
├── core/                  # Base interfaces (Integrator, RootFinder, EquationFunction, dEquationFunction)
├── methods/               
│   ├── integration/       # TrapezoidalMethod, SimpsonOneThirdMethod, SimpsonThreeEighthsMethod
│   ├── bracketing/        # BisectionMethod, FalsePositionMethod
│   └── iterative/         # NewtonRaphsonMethod, FixedPointMethod
└── Main.java              # Testing entry point
```

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Mohamedb12/Numerical-Analysis-Library.git
   ```
2. Compile the source code:
   ```bash
   javac core/*.java methods/*/*.java Main.java
   ```

---

## 👨‍💻 About the Author
Developed by **Mohammed**, a Computer Science student at the Faculty of Science, Assiut University (Department of Mathematics).

