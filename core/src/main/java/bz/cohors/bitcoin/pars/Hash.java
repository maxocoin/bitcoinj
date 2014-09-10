// -*-coding: mule-utf-8-unix; fill-column: 58; -*-

/**
 * @file
 * Altcoin parameters: hash function.
 *
 * @author Sergei Lodyagin
 */

package bz.cohors.bitcoin.pars;

import static com.hashengineering.crypto.X11.x11Digest;

public class Hash
{
	abstract public class Fun 
	{
	  abstract public byte[] hash(
	    byte[] input, 
	    int offset, 
	    int length
	  );
	  
	  public byte[] hash(byte[] input)
	  {
		  return hash(input, 0, input.length);
	  }
	};
	
	class X11 extends Fun
	{
	  public byte[] hash(
	    byte[] input, 
	    int offset, 
	    int length
	  )
	  {
	    return x11Digest(input, offset, length);
	  }
	};
	
  private Hash() {} // a singleton
	
	private static class Holder
	{
		private static final Hash the_hash = new Hash();
	  private static final Fun the_fun = the_hash.new X11();
	}
	
	public static Fun instance()
	{
	    return Holder.the_fun;
	}

};