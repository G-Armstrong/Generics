
public class Complex implements Arithmetic<Complex> {
	private int real, imaginary;
	/**
	 * Constructor
	 */
	public Complex() {
		real = 0; 
		imaginary =0;
	}
	/**
	 * Constructor with 2 parameters
	 * @param r of type int
	 * @param im of type int
	 */
	public Complex(int r,int im) {
		real = r;
		imaginary = im;
	}
	/**
	 * Adds to complex numbers and returns a new complex number
	 */
	public Complex add(Complex c) {
		int r = (real + c.real);
		int im = imaginary + c.imaginary;
		
		return new Complex(r, im);
		
	}
	/**
	 * Subtracts to complex numbers and returns a new complex number
	 */
	public Complex subtract(Complex c) {
		int r = (real - c.real);
		int im = imaginary - c.imaginary;
		
		return new Complex(r, im);
	}
	/**
	 * Multiplies to complex numbers and returns a new complex number
	 */
	public Complex multiply(Complex c) {
		int r = (real * c.real - imaginary * c.imaginary);
		int im = (real * c.imaginary + c.real * imaginary);
		
		return new Complex(r, im);
	}
	/**
	 * Divides to complex numbers and returns a new complex number
	 */
	public Complex divide(Complex c) {
		int r =(real * c.real + imaginary * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary);
		int im = (c.real * imaginary - real * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary);
		
		return new Complex(r, im);
	}
		
	/**
	 * Returns formatted output
	 */
	public String toString() {
		String output ="";
		if (real == 0 && imaginary == 0) {
			return "0";
		}
		else if(real == 0) {
			return imaginary + "i";
		}
		else if(imaginary==0) {
			output+=real;
			return output;
		}
		else {
			return real + "+" + imaginary + "i";
		}
		
	}

}
