package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomaintiposede
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"H"), "Hospital");
      domain.put(new String((String)"C"), "Cl�nica");
      domain.put(new String((String)"P"), "Policl�nico");
      domain.put(new String((String)"I"), "Independiente");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

