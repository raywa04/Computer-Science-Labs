public class SieveRunner
{
	public static void main(String[] args)
	{
		SieveOfEratos soe = new SieveOfEratos();
		int num = 11;
		System.out.println(num + " >>> " + soe.primes(num)+"\n");
		
		num = 21;
		System.out.println(num + " >>> " + soe.primes(num)+"\n");
		
		num = 128;
		System.out.println(num + " >>> " + soe.primes(num)+"\n");
	}
}